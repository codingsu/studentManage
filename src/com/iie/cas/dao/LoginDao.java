package com.iie.cas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getUserPassword(String userID) {
		
		String sql = "select count(*) from user where userid = ?";
		int userFlag = jdbcTemplate.queryForInt(sql,new Object[] { userID });
		String MD5PasswordStr = "";
		if(userFlag == 1)
		{
			sql = "select password from user where userid = ?";
			MD5PasswordStr = (String) jdbcTemplate.queryForObject(sql,
					new Object[] { userID }, java.lang.String.class);
		}
		return MD5PasswordStr;
	}
	
	public int findRole(String userId)
	{
		String sql = "select role from user where userid = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]{userId});
	}
}
