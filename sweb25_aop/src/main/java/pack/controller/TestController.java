package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MyModelInter;

@Controller
public class TestController {

	@Autowired
	@Qualifier("myModel")
	private MyModelInter modelInter;
	
	@RequestMapping("test")
	public ModelAndView abc() {
		String r1 = modelInter.processMsg();
		String r2 = modelInter.businessMsg();
		
		ModelAndView view = new  ModelAndView();
		view.setViewName("list");
		view.addObject("data1",r1);
		view.addObject("data2",r2);
		return view;
		
	}
}
















