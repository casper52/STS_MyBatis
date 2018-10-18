package org.casper.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.casper.mapper.TimeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper timemapper;
	
	@GetMapping("/home2")
	public void home2(String str, Model model) {
		logger.info("str........");
		logger.info(str);
		model.addAttribute("str",str);
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)	// 리플렉션: 어떤 클래스 어떤 메소드의 어떤애가 파라미터인지 알 수 있다.
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = timemapper.getTime2();
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		
	}
	
}
