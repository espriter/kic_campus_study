package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoInter;

@Controller
public class DeleteController {
	@Autowired
	private BoardDaoInter inter;
	
	@RequestMapping("delete")
	public String delPro(@RequestParam("num")String num,
		@RequestParam("page") String page) {
			if(inter.delete(num)) {
				return "redirect:/list?page=" + page;
			}else {
				return "err";
			}
		}
	}

