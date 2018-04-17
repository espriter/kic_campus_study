package pack1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("happy.do")
public class HappyController {
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView aaa() {
		System.out.println("HappyController aaa 수행");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view3");
		return modelAndView;
	}
}
