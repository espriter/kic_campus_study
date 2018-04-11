package aa.bb.my;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sub2Controller {
	
	@RequestMapping(value="/sub2", method=RequestMethod.GET)
	public ModelAndView def(HttpServletRequest request) {
		String irum = request.getParameter("irum");
	
		if(irum.equals("tom")) {
			String msg = irum + "님 환영합니다";
			return new ModelAndView("sub_list2", "msg", msg);
		}else {
			return new ModelAndView("redirect:resources/index.html");
		}
	}
}
