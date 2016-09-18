package com.iie.cas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iie.cas.dao.LoginDao;
import com.iie.cas.dao.StudentDao;
import com.iie.cas.entity.Student;
import com.iie.cas.util.MyUtil;
import com.iie.cas.util.MD5Util;

import static com.iie.cas.cons.CommonConstant.SALT;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private LoginDao loginDao;
	
	public void addStudent(String name, String sex, String grade,
			 String studentId,
			String password) throws Exception {
		MyUtil.checkStudentId(studentId);
		MyUtil.checkStudentName(name);
	

		Student stu = new Student();
		stu.setName(name);
		stu.setSex(sex);
		stu.setGrade(grade);
		stu.setStudentID(studentId);

		password = MD5Util.getMD5Str(password + SALT, null);
		studentDao.insert(stu, studentId, password);
	}

	public void UpdateStudent(String name, String sex, String grade,
			String phone, String mail,String studentId) throws Exception {
		
		Student stu = new Student();

		stu.setName(name);
		stu.setSex(sex);
		stu.setGrade(grade);
		stu.setMail(mail);
		stu.setPhone(phone);
		stu.setStudentID(studentId);
		
		studentDao.update(stu);
	}

	public void updateStudentImagePath(String studentid, String imagepath) throws Exception {
		MyUtil.checkNullOrEmpty(imagepath,studentid);
		studentDao.updateStudentImage(studentid,imagepath);
	}
	
	public void deteleStudent(String userId) throws Exception {
		MyUtil.checkNullOrEmpty(userId);
		studentDao.delete(userId);
	}

	public List<Student> findAll() {
		return studentDao.find();
	}

	public List<Student> findByName(String name) {
		return studentDao.selectByName(name);
	}

	public Student findStudentById(String studentId) {
		return studentDao.findStudentByStudentid(studentId);
	}
	
	public ArrayList<Student> getAllStudent()
	{
		return studentDao.getAllStudent();
	}
	
	public int changePassword(String oldPassword,String newPassword,String userId)
	{
		String oldPasswordMD5 = MD5Util.getMD5Str(oldPassword + SALT,null);
		if(oldPasswordMD5.equals(loginDao.getUserPassword(userId)))
		{
			try{
				newPassword = MD5Util.getMD5Str(newPassword + SALT,null);
				studentDao.updatePassword(userId, newPassword);
				return 1;
			}catch(Exception e)
			{
				e.printStackTrace();
				return -1;
			}
		}else{
			return 0;
		}
		
	}
	
	public void adminChangeStuPwd(String userId,String newPassword)
	{
		newPassword = MD5Util.getMD5Str(newPassword + SALT,null);
		studentDao.updatePassword(userId, newPassword);
	}
}
