package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private SangpumInter sangpumInter;
	
	@Override
	public void sangShow() {
		sangpumInter.sangpumList();
		
	}
}
