package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDto;
import pack.model.BoardInter;


@Controller
public class SearchController {
	
	@Autowired
	private BoardInter inter;
	
	@RequestMapping(value="search", method=RequestMethod.POST)
	public ModelAndView searchProcess(BoardBean bean) {
		List<BoardDto> list = inter.search(bean);
		return new ModelAndView("list","data",list);
	}
}
