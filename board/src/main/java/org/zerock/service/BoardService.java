package org.zerock.service;

import java.util.List;

import org.zerock.domain.Board;

public interface BoardService {
	
	public List<Board> getAll();
	
	public int register(Board board);

}
