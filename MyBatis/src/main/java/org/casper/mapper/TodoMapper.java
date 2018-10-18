package org.casper.mapper;

import java.util.List;

import org.casper.domain.Todo;

public interface TodoMapper {

	public List<Todo> select();
	
	public void insert(Todo todo);
	
	public void delete(Integer tno);
	
	public void update(Todo todo);
}
