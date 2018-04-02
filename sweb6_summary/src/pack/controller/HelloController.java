package pack.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.model.HelloModel;

public class HelloController implements Controller{
	private HelloModel helloModel;
	
	public void setHelloModel(HelloModel helloModel) {
		this.helloModel = helloModel;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//모델과 통신
		String result = helloModel.getMessage();
		
		//ModelAndView modelAndView = new ModelAndView("list"); //forward
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("list");
		//modelAndView.setViewName("redirect:/view/list.jsp");
		return modelAndView;
	}
}

