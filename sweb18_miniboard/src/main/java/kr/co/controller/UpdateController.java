package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.model.BoardInter;

@Controller
public class UpdateController {
	@Autowired
	private BoardInter inter;
	
	@RequestMapping("update")
	public String update(BoardBean bean) {
		boolean b = inter.update(bean);
		if(b) 
			return "redirect:/list";
		else
			return "err";
	}
}
