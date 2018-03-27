package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class DeleteAction implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		//모델과 통신
		int re = UserManager.instance().delete(userid);
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(re > 0) {
			modelAndView.setViewName("list.m2");		//삭제 후 목록보기
		}else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
}
