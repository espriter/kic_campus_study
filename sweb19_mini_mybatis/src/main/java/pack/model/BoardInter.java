package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.BoardBean;


public interface BoardInter {

	List<BoardDto> list() throws DataAccessException;
	
	List<BoardDto> search(BoardBean bean) throws DataAccessException;
	
	boolean writeData(BoardBean bean);
	
	BoardDto detail(String num);
}
