package pack;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface SawonInter {
	List<SawonDto> selectList() throws DataAccessException;
	
	
}
