package pack.model;

import java.util.Calendar;

import org.springframework.stereotype.Component;


@Component
public class HelloModel {
	public String getMessage() {
		int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String ss = "안녕하세요";
		
		if(h >= 6 && h <= 10) {
			ss = "좋은 아침";
		}else if(h >= 12 && h <= 15) {
			ss = "즐거운 오후 되세요";
		}else if( h >= 18 && h <= 24) {
			ss = "좋은 마무리 하세요";
		}
		
		return ss;
	}
}
