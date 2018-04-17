package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDto;
import pack.model.BoardInter;

@Controller
public class DetailController {
	
	@Autowired
	private BoardInter inter;
	
	@RequestMapping("detail")
	public ModelAndView list(@RequestParam("num") String num) {
		BoardDto dto = inter.detail(num);		
		
		return new ModelAndView("detail","dto",dto);
	}
}















