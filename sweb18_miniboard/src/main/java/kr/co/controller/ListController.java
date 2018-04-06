package kr.co.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.model.BoardDto;
import kr.co.model.BoardInter;

@Controller
public class ListController {
	
	@Autowired
	@Qualifier("boardDao")
	private BoardInter boardInter;
	
	@RequestMapping("list")
	public ModelAndView list() {
		List<BoardDto> list = boardInter.list();
		return new ModelAndView("list", "list", list);
	}
	
}
