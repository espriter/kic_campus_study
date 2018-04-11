package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("id") == null) {
			return "loginform";
		}else {
			return "redirect:/main.jsp";
		}
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String submit(HttpSession session,
			@RequestParam("id")String id,
			@RequestParam("pwd")String pwd) {
		if(id.equals("kor") && pwd.equals("111")) {
			session.setAttribute("id", id);
			return "redirect:/main.jsp";
		}else {
			return "redirect:/err.jsp";
		}
	}
	
	@RequestMapping()
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
}
