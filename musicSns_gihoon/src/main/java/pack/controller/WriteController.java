package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardDaoInter;

@Controller
public class WriteController {

	@Autowired
	private BoardDaoInter inter;

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "writeform";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeSubmit(BoardBean bean) {

		bean.setBdate(); // 등록일 날짜 셋팅
		int newNum = inter.currentNum() + 1; // 새글 번호
		bean.setNum(newNum); // 새글번호
		bean.setGnum(newNum); // 그룹번호

		if (inter.insert(bean)) {
			return "redirect:/i";
		} else {
			return "err";
		}

	}

}
