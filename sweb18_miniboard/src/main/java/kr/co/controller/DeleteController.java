package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.model.BoardInter;

@Controller
public class DeleteController {
	@Autowired
	private BoardInter inter;
	
	@RequestMapping("delete")
	public String delete(BoardBean bean) {
		boolean b = inter.delete(String.valueOf(bean.getNum()));
		
		if(b)
			return "redirect:/list";
		else
			return "err";
		
	}
}
