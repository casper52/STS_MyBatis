package org.casper.controller;

import org.casper.service.SampleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
})
@Log4j
public class SampleServiceTests {
	
	@Setter(onMethod_= @Autowired)
	private SampleService service;
	
	@Test
	public void testAdd()throws Exception{
		
		log.info(service.getClass().getName());
		log.info(service.doAdd("123", "100"));
		//log.info("RESULT: "+service.doAdd("123", null));
	}
	
	@Test
	public void testMulti() throws Exception{
		
		String str = "222222222333333333444444444222222222222긴글이안들어가야됨긴글이안들어가야됨긴글이안들어가야됨긴글이안들어가야됨긴글이안들어가야됨얼마나더길어야돼 얼마나더길어야되냐고";
		//String str = "짧은거";
		
		service.addMulti(str);
	}
}
