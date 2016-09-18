package com.iie.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.cas.dao.LoginDao;
import com.iie.cas.util.MyUtil;
import com.iie.cas.util.MD5Util;

import static com.iie.cas.cons.CommonConstant.SALT;
@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public int checkLogin(String userID,String password) throws Exception
	{
		MyUtil.checkNullOrEmpty(userID,password);
		int flag = 0;
		String passwordMD5 = MD5Util.getMD5Str(password + SALT,null);
		System.out.println(passwordMD5);
		System.out.println(loginDao.getUserPassword(userID));
		if(passwordMD5.equals(loginDao.getUserPassword(userID)))
		{
			flag = 1;
		}
		return flag;
	}
	
	public int getRole(String userId) throws Exception
	{
		MyUtil.checkNullOrEmpty(userId);
		return loginDao.findRole(userId);
	}
}
