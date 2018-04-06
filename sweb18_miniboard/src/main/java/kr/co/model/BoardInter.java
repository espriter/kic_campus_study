package kr.co.model;

import java.util.List;

import kr.co.controller.BoardBean;

public interface BoardInter {
	List<BoardDto> list();
	boolean writeData(BoardBean bean);
	List<BoardDto> search(String name, String value);
	BoardDto detail(String num);
	boolean update(BoardBean bean);
	boolean delete(String num);
}
