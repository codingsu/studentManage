package com.iie.cas.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.iie.cas.cons.CommonConstant;
import com.iie.cas.entity.Admin;
import com.iie.cas.entity.Student;
import com.iie.cas.service.AdminService;
import com.iie.cas.service.StudentService;
import com.iie.cas.util.MyUtil;

@Controller
public class StudentCotroller {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

	/*
	 * 添加用户
	 */
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addStudent(@RequestParam String name,
			@RequestParam String sex, @RequestParam String grade,
			@RequestParam String studentid, @RequestParam String password,
			HttpSession session, HttpServletRequest req) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			if (session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null) {
				modelMap.put("addResult", "pemission error");
				return modelMap;
			}
			// sex = URLDecoder.decode(sex, "utf-8");
			// grade = URLDecoder.decode(grade, "utf-8");

			studentService.addStudent(name, sex, grade, studentid, password);
			modelMap.put("addResult", "ok");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			modelMap.put("addResult", "error");
			return modelMap;
		}
		return modelMap;
	}

	/*
	 * 更新自己信息
	 */
	@RequestMapping(value = "/updatestudent", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> updateStudent(@RequestParam String name,
			@RequestParam String sex, @RequestParam String grade,
			@RequestParam String studentid, @RequestParam String phone,
			@RequestParam String mail, HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {

			if (session.getAttribute(CommonConstant.STUDENT_CONTEXT) != null
					&& session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null) {
				Student stu = (Student)session.getAttribute(CommonConstant.STUDENT_CONTEXT);
				if (!stu.equals(studentid)){
					modelMap.put("updateResult", "studentid error");
				    return modelMap;
				}
			}
			studentService.UpdateStudent(name, sex, grade, phone, mail,
					studentid);
			modelMap.put("updateResult", "ok");

		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("updateResult", "error");
			return modelMap;
		}
		return modelMap;
	}

	/*
	 * 删除普通用户
	 */
	@RequestMapping(value = "/deletestudent", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteStudent(@RequestParam String studentid,
			HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// ArrayList<Student> allStudent = new ArrayList<Student>();
		System.out.println(studentid);
		try {
			if (session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null) {
				modelMap.put("deleteResult", "Permission error");
				return modelMap;
			}
			studentService.deteleStudent(studentid);
			// allStudent = studentService.getAllStudent();
			// modelMap.put("allStudent", allStudent);
			modelMap.put("delectResult", "ok");
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("deleteResult", "error");
			return modelMap;
		}
		return modelMap;
	}

	@ResponseBody
	@RequestMapping(value = "/changepwd", method = RequestMethod.GET)
	public Map<String, Object> changePassword(@RequestParam String oldPassword,
			@RequestParam String newPassword, @RequestParam String userId,
			HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			int changgeResult = studentService.changePassword(oldPassword,
					newPassword, userId);
			if (changgeResult == 1) {
				modelMap.put("changeResult", "ok");
			}
			if (changgeResult == 0) {
				modelMap.put("changeResult", "oldPasswordError");
			}
			
		} catch (Exception e) {
			modelMap.put("changeResult", "error");
			return modelMap;
		}
		return modelMap;
	}

	@RequestMapping(value = "/allStudent")
	public String findAllStudent(Model model, HttpSession session) {
		if ((session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null && session
				.getAttribute(CommonConstant.STUDENT_CONTEXT) == null)
				|| session.getAttribute(CommonConstant.ROLE) == null) {
			session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
			session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
			session.removeAttribute(CommonConstant.ROLE);
			return "login";
		}
		try {
			model.addAttribute("allStudent", studentService.getAllStudent());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "allstudent";
	}

	@ResponseBody
	@RequestMapping(value = "/adminChangeStuPwd", method = RequestMethod.GET)
	public Map<String, Object> adminChangeStuPwd(@RequestParam String userId,
			@RequestParam String newPassword, HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {

			if (session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null || session.getAttribute(CommonConstant.ROLE).toString().equals('0')) {
				modelMap.put("adminChangePWResult", "Permission error");
				return modelMap;
			}

			studentService.adminChangeStuPwd(userId, newPassword);
			modelMap.put("adminChangePWResult", "ok");
			return modelMap;
		} catch (Exception e) {
			modelMap.put("adminChangePWResult", "error");
			return modelMap;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public List<Student> FindByName(@RequestParam String name) {
		try {
			return studentService.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public Student FindById(@RequestParam String id) {
		try {
			return studentService.findStudentById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/updateadmin", method = RequestMethod.GET)
	public Map<String, Object> updataAdmin(HttpSession session,
			@RequestParam String adminId, @RequestParam String phone,
			@RequestParam String mail) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null) {
			session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
			session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
			session.removeAttribute(CommonConstant.ROLE);
			modelMap.put("editResult", "Permission error");
			return modelMap;
		}
		try {
			adminService.updateAdminInfo(adminId, phone, mail);
			modelMap.put("editResult", "okr");
			return modelMap;
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("editResult", "error");
			return modelMap;
		}

	}

	@ResponseBody
	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public Map<String, Object> uploadImage(
			@RequestParam("file") CommonsMultipartFile upfile,
			@RequestParam String studentid, HttpServletRequest req,
			HttpSession session) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {

			Student stu =  (Student)session
					.getAttribute(CommonConstant.STUDENT_CONTEXT);
			Admin admin = (Admin)session.getAttribute(CommonConstant.ADMIN_CONTEXT);
			if(stu != null && admin == null){
				if(!stu.getStudentID().equals(studentid)){
					modelMap.put("uploadResult", "studentid error");
					return modelMap;
				}
			}
			if(stu == null && admin == null){
				modelMap.put("uploadResult", "user error");
				return modelMap;
			}
			

			if (!MyUtil.checkUploadImageName(upfile.getOriginalFilename())) {
				modelMap.put("uploadResult", "imagename error");
				return modelMap;
			}
			String filename = studentid + "."
					+ upfile.getOriginalFilename().split("\\.")[1];
			// |获取在Web服务器上的 绝对路径
			String path = req.getRealPath("/images");
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			// |获取输入流
			InputStream is = upfile.getInputStream();
			// |文件输出流
			OutputStream os = new FileOutputStream(new File(path, filename));
			// |循环写入
			int length = 0;
			byte[] buffer = new byte[1024];
			while ((length = is.read(buffer)) != -1) {
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			if(stu != null)
				studentService.updateStudentImagePath(studentid, path + filename);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("uploadResult", "error");
			return modelMap;
		}
		modelMap.put("uploadResult", "ok");
		return modelMap;
	}

	@RequestMapping(value = "/add")
	public String addPage(HttpSession session) {
		if (session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null) {
			session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
			session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
			session.removeAttribute(CommonConstant.ROLE);
			return "login";
		}
		return "add_user";
	}

	@RequestMapping(value = "/personal-{id}")
	public String personal(HttpSession session, @PathVariable String id,
			Model model) throws Exception {

		if ((session.getAttribute(CommonConstant.ADMIN_CONTEXT) == null && session
				.getAttribute(CommonConstant.STUDENT_CONTEXT) == null)
				|| session.getAttribute(CommonConstant.ROLE) == null) {
			session.removeAttribute(CommonConstant.ADMIN_CONTEXT);
			session.removeAttribute(CommonConstant.STUDENT_CONTEXT);
			session.removeAttribute(CommonConstant.ROLE);
			return "login";
		}
		System.out.println(session.getAttribute(CommonConstant.ROLE));
		if ((session.getAttribute(CommonConstant.ROLE)).toString().equals("1") && ((Admin)session.getAttribute(CommonConstant.ADMIN_CONTEXT)).getAdminId().equals(id)) {

			model.addAttribute("admin", adminService.getAdminByUserName(id));
			return "admin_profile";
		} else{
			model.addAttribute("student", studentService.findStudentById(id));
			return "person_profile";
		}

	}
	
	
	
	
	
	 @RequestMapping(value = "/uploadFile")
	  @ResponseBody
	  public void uploadFile(
	      @RequestParam(value="studentid") String studentid) {
		 //String filename = uploadfile.getOriginalFilename();
		// System.out.println(filename);
		 System.out.println(studentid);
	  
	  } // method uploadFile

}
