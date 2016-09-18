package com.iie.cas.entity;

public class Admin {

	private String adminId;//管理员id
	private String phone;//电话
	private String mail;//邮件
	private String imagePath;//照片路径
	private int role = 1;//角色  1代表管理员
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getRole()
	{
		return role;
	}
}
