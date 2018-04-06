package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.MemDaoInter;

@Controller
public class InsertController{
	@Autowired
	private MemDaoInter daoInter;
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert() {
		return "insform";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String submit(MemBean bean) {
		boolean b = daoInter.insertData(bean);
		if(b)
			return "redirect:/list";
		else
			//return "redirect:/err.jsp";
			return "err";
	}
}
