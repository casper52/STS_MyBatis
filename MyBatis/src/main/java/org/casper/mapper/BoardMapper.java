package org.casper.mapper;

import java.util.List;

import org.casper.domain.Board;
import org.casper.domain.PageParam;

public interface BoardMapper {

	public List<Board> search(PageParam pageParam); 		//scond: 검색조건
	
	public int searchCount(PageParam pageParam);	//count 쿼리
	
	
}
