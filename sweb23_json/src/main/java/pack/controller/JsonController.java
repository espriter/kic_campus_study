package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pack.model.MyModel;

@Controller
@RequestMapping("list")
public class JsonController {
	@Autowired
	private MyModel myModel;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody  //반환객체를 jsp 대신 Http 응답으로 전송 
	public MyModel getJson(@RequestParam("name") String name) {
		myModel.setName(name);
		myModel.setSkills(new String[] {"자바개발자","웹전문가"});
		return myModel;
	}
}





