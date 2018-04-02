package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyActionController{
	
	@RequestMapping("index.do")
	public ModelAndView abc() {
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("say","어노테이션 사용함");
		return modelAndView;
	}
	
	@RequestMapping("nice.do")
	public ModelAndView kbs() {
		ModelAndView modelAndView = new ModelAndView("list");
		modelAndView.addObject("say","나이스 요청");
		return modelAndView;
	}
	
	@RequestMapping("korea.do")
	public String sbs() {
		return "list";
	}
}
