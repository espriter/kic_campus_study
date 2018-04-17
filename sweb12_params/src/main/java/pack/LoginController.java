package pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="kor/login", params="type=admin")
	public ModelAndView kbs() {		//params 속성 값에 의해 요청 구분
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "관리자");
		
		return view;

	}
	
	@RequestMapping(value="kor/login", params="type=user")
	public ModelAndView mbc() {		//params 속성 값에 의해 요청 구분
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "일반 고객 회원입니다");
		
		return view;

	}
	
	@RequestMapping(value="kor/login", params="!type")
	public ModelAndView sbs() {		//params 속성 값에 의해 요청 구분
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		view.addObject("message", "나그네(무명인)");
		
		return view;

	}
	
	@RequestMapping(value="kor/{url}")
	public ModelAndView ytn(@RequestParam("type") String type,
												@PathVariable String url) {		//@PathVariable : 요청 url을 변수로 구분
//		ModelAndView view = new ModelAndView();
//		view.setViewName("showMessage");
//		String imsi = "기타 : " + type + " " + url;
//		view.addObject("message", imsi);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		if(url.equals("seoul")) {
			view.addObject("message","서울 사는" + type);
		}else if(url.equals("busan")) {
			view.addObject("message","부산 사는 " + type);
		}else {
			view.addObject("message", "그외 지역에 사는 " + type);
		}
		
		return view;

	}
	
	//  ent/sm/singer/psy?title=강남스타일
	@RequestMapping(value="/ent/{sosok}/singer/{gasu}")
	public ModelAndView jtbc(
			@RequestParam("title") String jemok,
			@PathVariable String sosok,
			@PathVariable String gasu) {	
		
		ModelAndView view = new ModelAndView();
		view.setViewName("showMessage");
		String msg = "소속사:" + sosok + ",가수:" + gasu + ", 노래제목:" + jemok;
		view.addObject("message",msg);
		
		return view;

	}
	
}








