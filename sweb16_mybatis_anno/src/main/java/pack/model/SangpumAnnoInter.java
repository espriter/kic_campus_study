package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pack.controller.SangpumBean;

public interface SangpumAnnoInter {
	//MyBatis SQL mapping interface
	@Select("select * from sangdata")
	public List<SangpumDto> selectAll();
	
	@Select("select * from sangdata where sang like concat('%',#{searchValue},'%')")
	public List<SangpumDto> selectSearch(SangpumBean bean);
}







