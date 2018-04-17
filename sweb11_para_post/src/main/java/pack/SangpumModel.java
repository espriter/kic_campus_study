package pack;

import org.springframework.stereotype.Component;

@Component
public class SangpumModel {
	public String compute(SangpumBean bean) {
		String data = "품명:";
		data += bean.getSang() + " ";
		data += ",금액:";
		data += bean.getSu() * bean.getDan();
		
		return data;
	}
}
