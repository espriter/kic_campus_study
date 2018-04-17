package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SangpumController {
	
	@Autowired
	@Qualifier("sangpumModel")
	private SangpumModel sangpumModel;
	
	@RequestMapping(value="sangpum", method=RequestMethod.POST)
	//public ModelAndView submit(SangpumBean bean) {
	public ModelAndView submit(@ModelAttribute("my") SangpumBean bean) {
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", sangpumModel.compute(bean));
		
		return view;
	}
	
	
	@ModelAttribute("myList")
	public List<String> aaa(){
		//request.setAttribute("myList",myList)  역할
		List<String> list = new ArrayList<String>();
		list.add("김밥");
		list.add("공기밥");
		return list;
		
	}
	
}















