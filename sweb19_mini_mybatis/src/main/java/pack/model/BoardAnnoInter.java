package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.BoardBean;


public interface BoardAnnoInter {

	 
	@Select("select * from miniboard order by num desc")
	public List<BoardDto> selectAll();
	
	
	@Select("select * from miniboard where title like concat('%',#{searchValue},'%')")
	public List<BoardDto> selectSearch(BoardBean bean);
	
	@Insert("insert into miniboard(author, title, content) values(#{author},#{title},#{content})")
	public boolean writeData(BoardBean bean);

	
	//@Update("update miniboard set readcnt=readcnt + 1 where num=#{num}")
	@Select("select * from miniboard where num=#{num}")
	public BoardDto detail(String num) ;
	
}
