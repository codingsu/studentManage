package com.iie.cas.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.iie.cas.entity.Student;

public class MyUtil {
	//允许上传的图片后缀名
	private static List<String> imagefilename = Arrays.asList(new String[]{"jpg","png","jpeg"});

	
	//判断文件名是否含有多余的小数点
	public static boolean checkUploadImageName(String name){
		String names[] = name.split("\\.");
		if(names.length != 2){
			return false;
		}else{
			//判断后缀名是否非法
			if(!imagefilename.contains(names[1]))
				return false;
			else
				return true;
		}
	}
	//判断是否是自己在操作自己的信息
	public static boolean checkIsRightStudent(String studentid, Student stu){
		if(stu == null || !stu.getStudentID().equals(studentid)){
			return false;
		}
		return true;
	}
	
	//校验参数是否为空
	public static boolean checkNullOrEmpty(Object... objs) throws Exception{
		for(Object obj:objs){
			if(obj == null || obj.toString().equals("")){
				throw  new Exception();
			}
		}
		return true;
	}
	//校验学号
	public static boolean checkStudentId(String studentid) throws Exception{
		if(studentid.length() == 15 || checkNullOrEmpty(studentid)){
			String regEx="[A-Z,a-z,0-9]*";
			return Pattern.compile(regEx).matcher(studentid).matches();
		}
		return false;
	}
	//校验名字
	public static boolean checkStudentName(String name) throws Exception{
		checkNullOrEmpty(name);
		if(name.length() > 50){
			return false;
		}
		return true;
	}
	//校验电话
	public static boolean checkPhone(String phone) throws Exception{
		checkNullOrEmpty(phone);
		if(phone.length() > 20)
			return false;
		String regEx="[0-9,-]*";
		return Pattern.compile(regEx).matcher(phone).matches();
	}
	
}
