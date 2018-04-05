package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class DetailContents {
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("detail")
	public ModelAndView detailProcess(@RequestParam("id")String id) {
		MemberDto dto = memberDao.getMember(id);
		return new ModelAndView("detail", "mem", dto);
	}
}
