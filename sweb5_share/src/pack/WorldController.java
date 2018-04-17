package pack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import pack.shared.SharedData;

public class WorldController implements Controller{
	
	private SharedData data;
	
	public void setData(SharedData data) {
		this.data = data;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		String ss= "World : " + data.getShared();
		modelAndView.addObject("abc", ss);
		return modelAndView;
	}
}











