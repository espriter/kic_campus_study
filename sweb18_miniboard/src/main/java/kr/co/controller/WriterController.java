package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.model.BoardInter;

@Controller
public class WriterController {
	@Autowired
	@Qualifier("boardDao")
	private BoardInter boardInter;
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "insform";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String submit(BoardBean bean) {
		boolean b = boardInter.writeData(bean);
		if(b)
			return "redirect:/list";
		else
			return "err";
	}
	
}
