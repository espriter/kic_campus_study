package pack.model;

import java.util.List;

import pack.controller.MemBean;

public interface MemDaoInter {
	List<MemDto> getDataAll();
	MemDto selectPart(String num);
	boolean insertData(MemBean bean);
	boolean updateData(MemBean bean);
	boolean deleteData(String num);
}
