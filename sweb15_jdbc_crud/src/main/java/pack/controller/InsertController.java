package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.MemberDao;

@Controller
public class InsertController {
	@Autowired
	private MemberDao memberDao;
	
	@ModelAttribute("command")
	public MemberBean formBack() {
		return new MemberBean();
	}
	private String formName = "insform";
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String form() {
		return formName;
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String submit(MemberBean bean) {
		//모델과 통신
		memberDao.insData(bean);
				
		return "redirect:/list"; // 추가 후 목록보기
	}
}
