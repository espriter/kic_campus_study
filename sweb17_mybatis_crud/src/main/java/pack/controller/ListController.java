package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemDaoInter;

@Controller
public class ListController {
		
	@Autowired
	@Qualifier("memDaoImpl")
	private MemDaoInter daointer;
	
	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("list");
		view.addObject("list", daointer.getDataAll());
		return view;
	}
	
}



