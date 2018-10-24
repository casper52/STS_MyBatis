package org.casper.mapper;

import org.casper.domain.Board;
import org.casper.domain.PageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testAll() {
		PageParam pageParam = new PageParam();
		log.info(mapper.getList(pageParam));
		mapper.getList(pageParam).forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("스프링에서 테스트 제목");
		board.setContent("내용");
		board.setWriter("나야나");
		
		log.info(mapper.insert(board));
	}
}
