package org.casper.service;

import java.util.List;

import org.casper.domain.Board;
import org.casper.domain.PageParam;
import org.casper.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;

	@Override
	public List<Board> getList(PageParam pageParam) {
		
		return mapper.getList(pageParam);
	}

	
	@Override
	public int register(Board board) {
		
		return mapper.insert(board);
	}


	@Override
	public int getTotal() {
		
		return mapper.count();
	}
	
	
}
