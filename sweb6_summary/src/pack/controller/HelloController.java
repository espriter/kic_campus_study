package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import pack.model.HelloModel;

/*
public class HelloController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		return null;
	}
}
*/

public class HelloController extends AbstractController{
	private HelloModel helloModel;
	
	public void setHelloModel(HelloModel helloModel) {
		this.helloModel = helloModel;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	
		//모델과 통신
		String result = helloModel.getMessage();
		
		//ModelAndView modelAndView = new ModelAndView("list");		//forward - 기본
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("list");		//forward(기본값)
		//modelAndView.setViewName("redirect:/view/list.jsp"); 		//redirect방식
		
		return modelAndView;
		
	}
}




















