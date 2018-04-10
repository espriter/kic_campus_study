package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class SearchController {
	@Autowired
	private BoardDaoInter inter;
	
	@RequestMapping("search")
	public ModelAndView process(BoardBean bean) {
		ArrayList<BoardDto> list = inter.getSearch(bean);
		
		ModelAndView view = new ModelAndView("list","data",list);
		view.addObject("page", "1");
		return view;
	}
}




