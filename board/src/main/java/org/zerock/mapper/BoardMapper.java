package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Board;
import org.zerock.domain.PageParam;

public interface BoardMapper {

	
	public List<Board> getList(PageParam param);
	
	public Board get(PageParam param);
	
	public int insert(Board board);
	
	public int count();
	
	public int delete(PageParam param);
	
	public int update(Board board);
}
