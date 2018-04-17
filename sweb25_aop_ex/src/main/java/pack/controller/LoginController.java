package pack.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpSession session) {
		if(session.getAttribute("id") == null) {
			return "login";
		}else {
			return "redirect:/sanglist.jsp";
		}
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		if(id.equals("kor") && pwd.equals("123")) {
			session.setAttribute("id", id);
			return "redirect:/sanglist.jsp";
		}else {
			return "redirect:/err.jsp";
		}
	}
	
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
}
















