package org.casper.controller;

import java.util.HashMap;
import java.util.Map;

import org.casper.domain.PageParam;
import org.casper.mapper.BoardMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends AbstractTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	

	@Test
	
	public void testSearch() {
		
		PageParam pageParam = new PageParam();
		
		pageParam.setTypes(new String[] {"t","c"});	//세번째 방법; 배열
		pageParam.setKeyword("Sample");
//		Map<String, String> cond = new HashMap<>(); 두번째 방법; 맵
//		cond.put("t","테스트");
//		cond.put("c","sample");
		
//		pageParam.setCond(cond);

		
		log.info(mapper.search(pageParam));
		
		log.info(mapper.searchCount(pageParam));
	}
	
}
