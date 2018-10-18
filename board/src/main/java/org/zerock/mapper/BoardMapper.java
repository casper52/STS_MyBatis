package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.Board;

public interface BoardMapper {

	@Select("select * from tbl_board order by bno desc")
	public List<Board> getListAll();
	
	@Insert("insert into tbl_board(title, content, writer) values(#{title},#{content},#{writer})")
	public int insert(Board board);
}
