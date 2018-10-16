package org.casper.controller;

import org.casper.domain.Todo;
import org.casper.mapper.TodoMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TodoMapperTests extends AbstractTests {
	
	@Setter(onMethod_=@Autowired)
	private TodoMapper mapper;
	
	@Test
	public void testRead() {
		log.info(mapper.select());
	}
	
	@Test
	public void testWrite() {
		mapper.insert("¾å");
	}
	
	@Test
	public void testDelete() {
		mapper.delete(12);
	}
	
	@Test
	public void testUpdate() {
		Todo todo = mapper.select().get(4);
		todo.setTitle("¾å¾ß¶ó¾å¾å");
		mapper.update(todo);
	}

}
