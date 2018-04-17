package pack.model;

import java.util.List;

public interface SawonInter {
	List<SawonDto> sawonList();
	
	SawonDto getLogInfo(String no);
}
