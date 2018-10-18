package org.casper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.casper.domain.StoreVO;
import org.casper.domain.Todo;
import org.casper.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class TodoServiceImpl implements TodoService {

	private Map<String, List<StoreVO>> storeMap;
	@Setter(onMethod_= @Autowired)
	private TodoMapper mapper;
	
	public TodoServiceImpl() {
		storeMap = new HashMap<>();
		
		List<StoreVO> korList = new ArrayList<>();
		korList.add(new StoreVO(1,"청진식당"));
		korList.add(new StoreVO(2,"뚝배기집"));
		korList.add(new StoreVO(3,"마마된장"));
		
		storeMap.put("kor", korList);
		
		List<StoreVO> jpList = new ArrayList<>();
		jpList.add(new StoreVO(1,"이춘복참치"));
		jpList.add(new StoreVO(2,"가쓰야"));
		jpList.add(new StoreVO(3,"갓덴스시"));
		
		storeMap.put("jp", jpList);
	}
	
	
	
	@Override
	public List<Todo> getList() {
		
		return mapper.select();
		
	}
	

	@Override
	public List<StoreVO> getStores(String cat) {
		
		return storeMap.get(cat);
	}



	@Override
	public void insert(Todo todo) {
		mapper.insert(todo);
		
	}

}
