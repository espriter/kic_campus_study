package pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pack.model.SawonDto;
import pack.model.SawonInter;

@Controller
public class SawonlistController {
	
	@Autowired
	@Qualifier("sawonImpl")
	private SawonInter sawonInter;
	
	@RequestMapping("sawonlist")
	public ModelAndView kbs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView();
		List<SawonDto> list = sawonInter.sawonList();
		view.setViewName("sawonlist");				//생략가능하지만 가독성위해 쓰는것을 권장.
		view.addObject("list",list);
		return view;
	}
}










