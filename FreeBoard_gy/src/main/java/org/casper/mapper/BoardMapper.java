package org.casper.mapper;

import java.util.List;

import org.casper.domain.Board;

public interface BoardMapper {

	public List<Board> getList();
	
	public int insert(Board board);
	
}
