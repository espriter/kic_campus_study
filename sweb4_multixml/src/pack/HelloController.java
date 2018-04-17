package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("HelloController 수행 : 모델과 통신 가능");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","hello(헬로우)");
		modelAndView.setViewName("view1");
		
		return modelAndView;
		
	}
}
