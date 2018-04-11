package pack.model;

import java.util.List;

public interface DataInter {
	public List<SawonDto> sawonList(String buser_name);
	public List<GogekDto> gogekList(String sawon_no);
}
