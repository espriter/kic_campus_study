package pack1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorldController {
	@RequestMapping(value="kbs/world.do",method=RequestMethod.GET)
	public ModelAndView method1() {
		System.out.println("WorldController method1 수행");
		
		ModelAndView modelAndView = new ModelAndView("view2");
		modelAndView.addObject("message", "world(get) 요청");
		return modelAndView;
		
	}
	
	@RequestMapping(value="kbs/world.do",method=RequestMethod.POST)
	public ModelAndView method2() {
		System.out.println("WorldController method1 처리");
		
		ModelAndView modelAndView = new ModelAndView("view2");
		modelAndView.addObject("message", "world(post) 요청");
		return modelAndView;
		
	}
}
