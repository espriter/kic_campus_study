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
public class SearchController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter boardInter;
	
	@RequestMapping("search")
	public ModelAndView search(BoardBean bean) {
		System.out.println(bean.getSearchValue());
		List<BoardDto> list = boardInter.search(bean.getSearchName(), bean.getSearchValue());
		return new ModelAndView("list", "list", list);
	}
}
