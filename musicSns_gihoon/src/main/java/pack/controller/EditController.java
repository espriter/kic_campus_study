package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.model.BoardDaoInter;

@Controller
public class EditController {

	@Autowired
	private BoardDaoInter inter;
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("num") String num, @RequestParam("page") String page) {
		
		ModelAndView view = new ModelAndView("edit","data",inter.getDetail(num));
		view.addObject("page",page);
		return view;
		
	}
	

	@RequestMapping(value="edit", method=RequestMethod.POST)
	public ModelAndView editSubmit(@RequestParam("page") String page, BoardBean bean) {
		
		//비밀번호 체크
		String pass = inter.selectPass(Integer.toString(bean.getNum()));

		ModelAndView view = new ModelAndView();
		
		//수정
		if(bean.getPass().equals(pass)) {
			inter.update(bean);
			view.setViewName("detail");			//수정 후 상세보기
		}else {
			view.setViewName("edit");
			view.addObject("msg","비밀번호 불일치!");
		}
		
		view.addObject("data",bean);
		view.addObject("page",page);
		return view;
	}

}











