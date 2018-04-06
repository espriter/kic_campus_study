package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pack.model.SangpumInter;

@Controller
public class ListController {
	
	@Autowired
	private SangpumInter inter;
	
	@RequestMapping("list")
	public String process(Model model) {
		model.addAttribute("data",inter.list());
		return "sanglist";
	}
}
