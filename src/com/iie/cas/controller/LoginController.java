package com.iie.cas.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iie.cas.cons.CommonConstant;
import com.iie.cas.entity.Admin;
import com.iie.cas.entity.Student;
import com.iie.cas.service.AdminService;
import com.iie.cas.service.LoginService;
import com.iie.cas.service.StudentService;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

	@RequestMapping({ "/login", "/", "logins", "/login.jsp", "/login.html" })
	public String login(HttpSession session) {
		return "login";
	}

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public Object checkLogin(@RequestParam String username,
			@RequestParam String password, HttpSession session) {
		try {
			System.out.println(username + "   " + password);
			int flag;

			flag = loginService.checkLogin(username, password);

			if (flag == 1) {
				int role = loginService.getRole(username);
				session.setAttribute(CommonConstant.ROLE, role);
				if (role == 1)// 管理员
				{
					Admin admin = new Admin();
					admin = adminService.getAdminByUserName(username);
					session.setAttribute(CommonConstant.ADMIN_CONTEXT, admin);
					session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
				} else {// 普通用户
					Student student = new Student();
					student = studentService.findStudentById(username);
					session.setAttribute(CommonConstant.STUDENT_CONTEXT, student);
					session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
				}
				return "redirect: /allStudent";
			} else {
				return new ModelAndView("login", "error", "用户名或密码错误。");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/home")
	public String homePage(Model model,HttpSession session)
	{
		if ((session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null && session
				.getAttribute(CommonConstant.STUDENT_CONTEXT) == null)
				|| session.getAttribute(CommonConstant.ROLE) == null) {
			session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
			session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
			session.removeAttribute(CommonConstant.ROLE);
			return "login";
		}
		try {
			//model.addAttribute("allStudent",studentService.getAllStudent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "allstudent";
	}
	
	
	@RequestMapping(value = "/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
		session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
		session.removeAttribute(CommonConstant.ROLE);
		return "login";
	}

	@RequestMapping(value = "/forgetpwd")
	@ResponseBody
	public Map<String, Object> findPassword() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		Admin admin = new Admin();
		admin = adminService.getAdmin();
		modelMap.put("phone", admin.getPhone());
		modelMap.put("mail", admin.getMail());
		return modelMap;
	}
	
	@RequestMapping(value="/index_content")
	public String first()
	{
		return "index_content";
	}
	
	@RequestMapping(value="/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping(value="/help")
	public String help()
	{
		return "help";
	}
}
