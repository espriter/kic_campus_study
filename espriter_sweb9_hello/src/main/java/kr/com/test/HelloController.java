package kr.com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.HelloModel;

@Service
@Controller
@ComponentScan("pack.model")
public class HelloController {
	
	@Autowired
	private HelloModel helloModel;
	
	@RequestMapping("hello")
	public String abc(Model model) {
		String ss = helloModel.getMessage();
		
		model.addAttribute("msg", ss);
		return "list";
	}
}
