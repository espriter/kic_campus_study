package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
	@RequestMapping("hello.do")
	public ModelAndView m1() {
		System.out.println("HelloController v1 처리");
		
		ModelAndView modelAndView = new ModelAndView("view1");
		modelAndView.addObject("message","get, post 으로 처리");
		return modelAndView;
	}
}
