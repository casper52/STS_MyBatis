package org.casper.controller;

import org.casper.domain.Board;
import org.casper.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void listAll(Model model) {
		log.info("list page....");
		model.addAttribute("list",service.getListAll());
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	@PostMapping("/register")
	public String registerPOST(Board board, RedirectAttributes rttr) {
		log.info(board);
		int result = service.register(board);
		log.info(result);
		
		rttr.addFlashAttribute("result", result == 1?"SUCCESS":"FAIL");
		return "redirect:/board/list";
		
	}
}
