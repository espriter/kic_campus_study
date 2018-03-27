package kr.mvc.model;

import java.util.ArrayList;

import kr.mvc.controller.UserForm;

public class UserManager {		//여러개의 DAO 클래스를 관리가 목적
	
	public UserManager() {
	
	}
	
	private static UserManager manager = new UserManager();
	public static UserManager instance() {
		return manager;
	}
	
	private UserDaoModel getUserDaoModel() {
		return new UserDaoModel();
	}
	

	public boolean login(String user_id, String user_password) {
		UserDto dto = getUserDaoModel().findUser(user_id);
		if(dto == null) return false;
		if(dto.getPassword().equals(user_password)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public ArrayList<UserDto> getUserAll(){
		return getUserDaoModel().getuserAll();
	}
	
	public int insert(UserForm userForm) {
		return getUserDaoModel().insertData(userForm);
	}
	
	public UserDto findUser(String userid) {		//view에서 사용
		return getUserDaoModel().findUser(userid);
	}
	
	public int update(UserForm userForm) {
		return getUserDaoModel().updateData(userForm);
	}
	
	public int delete(String userid) {
		return getUserDaoModel().deleteData(userid);
	}

	
	
}













