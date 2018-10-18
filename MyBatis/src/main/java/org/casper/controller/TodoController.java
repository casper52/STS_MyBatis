package org.casper.controller;

import java.util.Arrays;
import java.util.List;

import org.casper.domain.OrderList;
import org.casper.domain.StoreVO;
import org.casper.domain.Todo;
import org.casper.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/todo/*")	// 경로가 todo로 시작하는 애들을 모두 받아먹는다.
@Log4j
@AllArgsConstructor
public class TodoController {
	
	private TodoService service;
	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
		return service.getStores(cat);
	}
	
	@GetMapping("/list2")
	@ResponseBody				// jsp가 필요하지않다. json 변환.
	public ResponseEntity<List<Todo>> list2(){
		//return service.getList();
		return new ResponseEntity<List<Todo>>(service.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/todolist")
	public void todolist() {
		log.info("todolist....page");
		
	}
	
	@PostMapping("/todolist")
	public String todolistPost(Todo todo, RedirectAttributes rttr) {
		log.info("Add List...");
		
		log.info(todo);
		
		service.insert(todo);
		
		rttr.addFlashAttribute("result", "SUCCESS");
		return "redirect:/todo/todolist";
	}
	@GetMapping("/list")
	public void list() {
		log.info("list....page");
	}

	// 등록화면
	@GetMapping("/register")
	public void register() {
		log.info("register");
	}
	
	@GetMapping("/exArray")
	public String exArray(String[] ids) {
		log.info(Arrays.toString(ids));
		return "todo/success";
	}
	
	@GetMapping("/order")
	public String order(OrderList list, Model model ) {	// 리스트를 못 쓰는 이유: 리스트는 인터페이스타입이라 new를 할 수 없어서 파라미터수집이 안됨.
		log.info(list);
		
		model.addAttribute("total", 3000);
		return "todo/success";
	}
	
	@PostMapping("/register")
	public String registerPost(Todo todo, RedirectAttributes rttr) {	//자동으로 파라미터 받아올 수 있다.
		log.info(todo);
		
		rttr.addFlashAttribute("result", "SUCCESS");
		
		return "redirect:/todo/list"; 
	}
}
