package pack.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pack.model.HelloModel;

@Controller
//@RequestMapping("hello.do")
@RequestMapping({"hello.do","hi","abc/world","k*"})
public class HelloController {
	
	@Autowired
	private HelloModel helloModel;
	

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView abc() {
		String result = helloModel.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		modelAndView.addObject("result", result);
		
		return modelAndView;
		
	}


	/*
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> abc(){
		String result = helloModel.getMessage();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("result", result);
		//view 파일명은 요청파일명이 된다.
		return map;
	}
	*/
	
	/*
	@RequestMapping(method=RequestMethod.GET)
	public Model abc(Model model) {
		String result = helloModel.getMessage();
		
		model.addAttribute("result","result");
		//view 파일명은 요청파일명이 된다.
		return model;
	}
	*/
	
	/*
	 * 
	@RequestMapping(method=RequestMethod.GET)
	public Model abc(Model model) {
		String result = helloModel.getMessage();
		
		model.addAttribute("result","result");
		//view 파일명은 요청파일명이 된다.
		return 뷰파일명;
	}
	
	 * */
}












