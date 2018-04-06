package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.SanpumBean;

public interface SangpumInter {
	List<SangpumDto> list() throws DataAccessException;
	List<SangpumDto> search(SanpumBean bean) throws DataAccessException;
	
	
}
