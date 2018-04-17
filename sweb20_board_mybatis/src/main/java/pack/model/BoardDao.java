package pack.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao  extends SqlSessionDaoSupport implements BoardDaoInter{
	
	@Autowired
	public BoardDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<BoardDto> getList() {
		return getSqlSession().selectList("selectlist");
	}
	
	public ArrayList<BoardDto> getSearch(BoardBean bean) {
		return getSqlSession().selectOne("selectchList", bean);
	}
	
	public boolean insert(BoardBean bean) {
		try {
			getSqlSession().insert("insertData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("insertData err : " + e);
			return false;
		}
	}
	
	public BoardDto getDetail(String num) {
		return getSqlSession().selectOne("searchOne",num);
	}
	
	public boolean update(BoardBean bean) {
		try {
			getSqlSession().update("updateData", bean);
			return true;
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			return false;
		}
	}
	
	public boolean delete(String num) {
		try {		
			int re = getSqlSession().update("deleteData", num);
			if(re > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			return false;
		}

	}

	public int currentNum() {
		return getSqlSession().selectOne("currentMaxNum");
	}

	public int totalCnt() {
		return getSqlSession().selectOne("totalCnt");
	}

	public boolean updateReadcnt(String num) {
		return getSqlSession().selectOne("updateReadcnt",num);
	}

	public String selectPass(String num) {
		return getSqlSession().selectOne("selectpass",num);
	}

	public boolean updateOnum(BoardBean bean) {
		return getSqlSession().selectOne("updateOnum",bean);
	}

	public boolean insertReply(BoardBean bean) {
		return getSqlSession().selectOne("insertReData",bean);
	}



}
