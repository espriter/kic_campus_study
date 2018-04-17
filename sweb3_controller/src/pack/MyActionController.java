package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyActionController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// Model과 통신하기 위한 Controller 서브 클래스
		System.out.println("모델은 수행했다 가정");
		
		//return new ModelAndView("list");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("say","안녕");
		modelAndView.setViewName("list");			//forwarding
		return modelAndView;
		
	}
}
