package org.casper.service;

import java.util.List;

import org.casper.domain.StoreVO;
import org.casper.domain.Todo;

public interface TodoService {

	public List<Todo> getList();
	
	public void insert(Todo todo);
	
	public List<StoreVO> getStores(String cat);
}
