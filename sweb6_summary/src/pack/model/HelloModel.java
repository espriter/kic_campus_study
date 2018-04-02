package pack.model;

import java.util.Calendar;

public class HelloModel { // 모델 파트의 클래스
	public String getMessage() {
		int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String ss = "안녕하세요";
		
		if(h >= 6 && h <= 10) {
			ss = "좋은 아침";
			
		}else if(h >= 12 && h <= 15) {
			ss = "맥런치 먹을 시간";
		}else if(h >= 18 && h <= 24) {
			ss = "즐거운 저녁 시간";
		}
		
		return ss;
	}
}
