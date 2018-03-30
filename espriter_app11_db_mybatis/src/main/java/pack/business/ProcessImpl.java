package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DaoInter;
import pack.model.SangpumDto;

@Service
public class ProcessImpl implements ProcessInter{
	@Autowired
	private DaoInter daoInter;
	
	@Override
	public void dataShow() {
		List<SangpumDto> list = daoInter.selectDataAll();
		
		for(SangpumDto sang:list) {
			System.out.println(sang.getCode() + " " + 
					sang.getSang() + " " +
					sang.getSu() + " " +
					sang.getDan());
			
		}
		
	}
	
}
