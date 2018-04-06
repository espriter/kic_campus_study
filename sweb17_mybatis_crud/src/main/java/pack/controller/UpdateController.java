package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemDaoInter;
import pack.model.MemDto;

@Controller
public class UpdateController {
	@Autowired
	@Qualifier("memDaoImpl")
	private MemDaoInter daoInter;
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView up(@RequestParam("num") String num) {
		MemDto dto = daoInter.selectPart(num);
		return new ModelAndView("upform", "dto", dto);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String submit(MemBean bean) {
		boolean b = daoInter.updateData(bean);
		
		if(b)
			return "redirect:/list"; //수정 후 목록 보기
		else
			return "err";
	}
}
