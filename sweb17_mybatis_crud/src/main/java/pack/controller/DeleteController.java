package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemDaoInter;

@Controller
public class DeleteController {
	@Autowired
	@Qualifier("memDaoImpl")
	private MemDaoInter daoInter;
	
	@RequestMapping("delete")
	public String del(@RequestParam("num")String num) {
		boolean b =daoInter.deleteData(num);
		if(b)
			return "redirect:/list";
		else
				return "err";
	}
}
