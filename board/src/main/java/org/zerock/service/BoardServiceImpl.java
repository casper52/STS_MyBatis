package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Board;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;

	@Override
	public List<Board> getAll() {
		
		return mapper.getListAll();
	}
	
	@Override
	public int register(Board board) {
		return mapper.insert(board);
	}

}
