package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDaoInter{
	@Autowired
	public BoardDaoImpl(SqlSessionFactory factory) {
		this.setSqlSessionFactory(factory);
	}
	
	public ArrayList<BoardDto> getList() {
		return (ArrayList)getSqlSession().selectList("selectList");
	}
	
	public ArrayList<BoardDto> getSearch(BoardBean bean) {
		return (ArrayList)getSqlSession().selectList("searchList", bean);
	}
	
	public boolean insert(BoardBean bean) {
		int re = getSqlSession().insert("insertData", bean);
		if (re > 0)
			return true;
		else
			return false;
	}
	
	public BoardDto getDetail(String num) {
		return getSqlSession().selectOne("selectOne", num);
	}
	
	public boolean update(BoardBean bean) {
		int re = getSqlSession().update("updateData", bean);
		if (re > 0)
			return true;
		else
			return false;
	}
	
	public boolean delete(String num) {
		int re = getSqlSession().delete("deleteData", num);
		if (re > 0)
			return true;
		else
			return false;
	}
	
	public int currentNum() {
		if(getSqlSession().selectOne("currentMaxNum") == null)
			return 0;
		
		return getSqlSession().selectOne("currentMaxNum");
	}
	
	public int totalCnt() {
		return getSqlSession().selectOne("totalCnt");
	}
	
	public boolean updateReadcnt(String num) {
		int re = getSqlSession().update("updateReadcnt", num);
		if (re > 0)
			return true;
		else
			return false;
	}
	
	public String selectPass(String num) { //수정 시 비밀번호 비교
		return getSqlSession().selectOne("selectpass", num);
	}
	
	public boolean updateOnum(BoardBean bean) {  //댓글용
		int re = getSqlSession().update("updateOnum", bean);
		if (re > 0)
			return true;
		else
			return false;
	}
	
	public boolean insertReply(BoardBean bean) { //댓글등록
		int re = getSqlSession().insert("insertReData", bean);
		if (re > 0)
			return true;
		else
			return false;
	}
}
