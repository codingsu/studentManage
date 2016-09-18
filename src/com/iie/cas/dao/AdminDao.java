package com.iie.cas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.iie.cas.entity.Admin;

@Repository
public class AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Admin findAdminByAdminId(String adminId)
	{
		final Admin admin = new Admin();
		String sql = "select * from admin where adminid = ?";
		jdbcTemplate.query(sql, new Object[] { adminId },
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						admin.setAdminId(rs.getString("adminid"));
						admin.setImagePath(rs.getString("imagepath"));
						admin.setMail(rs.getString("mail"));
						admin.setPhone(rs.getString("phone"));
					}
				});
		
		return admin;
	}
	
	public Admin findAdminByRole()
	{
		final Admin admin = new Admin();
		String sql = "Select * from admin where adminid = (select userid from user where role = 1)";
		jdbcTemplate.query(sql,
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						admin.setAdminId(rs.getString("adminid"));
						admin.setImagePath(rs.getString("imagepath"));
						admin.setMail(rs.getString("mail"));
						admin.setPhone(rs.getString("phone"));
					}
				});
		
		return admin;
	}
	
	public void updateAdmin(String adminID,String phone,String mail)
	{
		String sql = "update admin set phone=?,mail=? where adminid = ?";
		jdbcTemplate.update(sql, new Object[]{phone,mail,adminID});
		
	}

}


