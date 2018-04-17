package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;


@Controller
public class ListController {

	@Autowired
	private BoardDaoInter inter;
	
	@RequestMapping("list")
	private ModelAndView list() {
		ModelAndView view = new ModelAndView("list");
		view.addObject("data",inter.getList());
		return view;
	}
}














