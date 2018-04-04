package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class ListController {
	
	@Autowired
	private MemberDao memberDao;
	private int pageSize = 3; // 페이지 당 출력 행 수
		
	@RequestMapping("list") // http://~~list?pageNum=? 으로 보내기
	public ModelAndView listProcess(
		@RequestParam(value="pageNum", defaultValue="1")String pageNum) {
		//모델과 통신
		int currentPage = Integer.parseInt(pageNum); //pagenum을 숫자로 받음
		int startR = (currentPage -1) * pageSize; // 3페이지를 보여달라고 하면 6...
		int endR = pageSize;
		int count = memberDao.getMemberCount(); //페이지 수 얻기
		List<MemberDto> list = null;
		//list = memberDao.getMemberAll(); // 페이지 X
		list = memberDao.getMemberAll(startR, endR); // 페이지 분할 O
		
		ModelAndView view = new ModelAndView();
		view.setViewName("list");
		
		view.addObject("list", list);
		view.addObject("currentPage", currentPage);
		view.addObject("count", count);
		view.addObject("pageSize", pageSize);
		
		return view;
	}
}
