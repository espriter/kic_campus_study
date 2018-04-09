package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.model.BoardDto;
import kr.co.model.BoardInter;

@Controller
public class DetailController {
	@Autowired
	private BoardInter inter;
	
	@RequestMapping
	public ModelAndView list(@RequestParam("num")String num) {
		BoardDto dto = inter.detail(num);
		return new ModelAndView("detail","dto",dto);
	}
	
}
