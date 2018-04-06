package pack.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SangpumDto;
import pack.model.SangpumInter;

@Controller
public class SearchController {
	private SangpumInter inter;
	
		@RequestMapping(value="search", method=RequestMethod.POST)
		public ModelAndView searchProcess(SanpumBean bean) {
		List<SangpumDto> list = inter.search(bean);
		return new ModelAndView("sanglist", "data", list);
	}
	
}
