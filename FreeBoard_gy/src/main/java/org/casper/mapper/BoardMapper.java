package org.casper.mapper;

import java.util.List;

import org.casper.domain.Board;
import org.casper.domain.PageParam;

public interface BoardMapper {

	public List<Board> getList(PageParam pageParam);
	
	public int insert(Board board);
	
	public int count();
	
}
