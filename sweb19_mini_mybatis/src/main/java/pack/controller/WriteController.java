package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.BoardInter;



@Controller
public class WriteController {

	@Autowired
	private BoardInter Inter;

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {
		return "insform";
	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String submit(BoardBean bean) {
		boolean b = Inter.writeData(bean);

		if (b)
			return "redirect:/list";
		else
			return "err";
	}
}
