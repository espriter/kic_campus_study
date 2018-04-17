package pack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// 방법1 : 전통적인 방식 
/*@Controller
//@Service
public class LoginController {

		@RequestMapping(value="login", method=RequestMethod.GET)
		public ModelAndView submit(HttpServletRequest request) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			String data = "";
			if(id.equals("aa") && pwd.equals("11")) data="로그인 성공";
			else data = "로그인 실패";
			
			ModelAndView view = new ModelAndView("showMessage");
			view.addObject("data",data);
			return view;
			
			
		}
		
}

*/

//방법2 : 스프링을 이용한 방식
@Controller
@RequestMapping(value="login")
public class LoginController {
		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView submit(
				@RequestParam("id") String id,
				@RequestParam("pwd") String pwd ) {
			String data = "";
			if(id.equals("aa") && pwd.equals("11")) data="로그인 성공";
			else data = "로그인 실패";
			
			ModelAndView view = new ModelAndView("showMessage");
			view.addObject("data",data);
			return view;
			
			
		}
		
}


















