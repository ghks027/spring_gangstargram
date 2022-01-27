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
		return userDAO.insertUser(loginId, EncryptUtils.md5(password), name, email);
	}
	
	// 중복확인
	public boolean isDuplicateId(String loginId) {
		int count = userDAO.selectCountId(loginId);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
