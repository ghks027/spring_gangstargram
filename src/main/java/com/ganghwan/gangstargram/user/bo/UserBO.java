package com.ganghwan.gangstargram.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganghwan.gangstargram.common.EncryptUtils;
import com.ganghwan.gangstargram.user.dao.UserDAO;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	// 회원가입
	public int addUser(String loginId, String password, String name, String email) {
		
		String encPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encPassword, name, email);
	}
}
