package com.iie.cas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.cas.dao.AdminDao;
import com.iie.cas.entity.Admin;
import com.iie.cas.util.MyUtil;
@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public Admin getAdminByUserName(String adminId) throws Exception
	{
		MyUtil.checkNullOrEmpty(adminId);
		return adminDao.findAdminByAdminId(adminId);
	}
	
	public Admin getAdmin()
	{
		return adminDao.findAdminByRole();
	}
	
	public void updateAdminInfo(String adminID,String phone,String mail)
	{
		adminDao.updateAdmin(adminID, phone, mail);
	}

	
}
