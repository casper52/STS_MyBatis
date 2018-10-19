package org.casper.service;

import java.util.List;

import org.casper.domain.Board;

public interface BoardService {

	public List<Board> getListAll();
	
	public int register(Board board);
}
