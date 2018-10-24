package org.casper.service;

import java.util.List;

import org.casper.domain.Board;
import org.casper.domain.PageParam;

public interface BoardService {

	public List<Board> getList(PageParam pageParam);
	
	public int getTotal();
	
	public int register(Board board);
}
