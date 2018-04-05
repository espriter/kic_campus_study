package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	@Autowired
	private MemberDao memberdao;
	
	private String formName = "upform";
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("id")String id) {
		MemberDto dto = memberdao.getMember(id);
		//System.out.println(dto.getId() + " " + dto.getName());
		return new ModelAndView(formName, "updata", dto);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView submit(MemberBean bean) {
		memberdao.upData(bean);
		
		return new ModelAndView("redirect:/list"); // 수정 후 목록 보기
	}
}
