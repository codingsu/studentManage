package com.iie.cas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.iie.cas.entity.Student;

@Repository
public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Student> find() {
		String sql = "select * from student";
		return jdbcTemplate.query(sql, new UserMapper());
	}

	private static final class UserMapper implements RowMapper<Student> {

		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Student studentvo = new Student();
			studentvo.setStudentID(rs.getString("studentid"));
			studentvo.setName(rs.getString("name"));
			studentvo.setSex(rs.getString("sex"));
			studentvo.setGrade(rs.getString("grade"));
			studentvo.setImagePath(rs.getString("imagepath"));
			studentvo.setMail(rs.getString("mail"));
			studentvo.setPhone(rs.getString("phone"));
			return studentvo;
		}

	}

	public void delete(String userid) {
		// TODO Auto-generated method stub
		String sql = "delete from user where userid = ?";
		jdbcTemplate.update(sql, userid);
	}

	public void insert(Student studentvo,String userId,String password) {
		// TODO Auto-generated method stub
		String sql = "insert into user (userid,password,role) values(?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] {userId,password,0});
		
		sql = " insert into student (name,sex,grade,studentid,imagepath) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] { studentvo.getName(), studentvo.getSex(),
						studentvo.getGrade(),
						studentvo.getStudentID(),"/metronic/assets/admin/pages/media/profile/profile-img.png" });
	}

	public Student select(String studentId) {
		// TODO Auto-generated method stub
		String sql = "select * from student where studentid= ?";
		return jdbcTemplate.queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Student.class),
				studentId);

	}

	public List<Student> selectByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from student where name=?";
		try {
			return jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper
					.newInstance(Student.class), name);
		} catch (Exception e) {
			return null;
		}

	}

	public void update(Student studentvo) {
		String sql = "update student set name=?,sex=?,grade=?,phone=?,mail=? where studentid = ?";
		jdbcTemplate.update(sql, new Object[]{studentvo.getName(), studentvo.getSex(),
				studentvo.getGrade(),
				studentvo.getPhone(), studentvo.getMail(),
				studentvo.getStudentID()});
	}
	
	public void updatePassword(String userId,String newPassword)
	{
		String sql = "update user set password = ? where userid = ?";
		jdbcTemplate.update(sql, new Object[]{newPassword,userId});
	}
	
	public void updateStudentImage(String studentId,String studentimagepath)
	{
		String sql = "update student set imagepath = ? where studentid = ?";
		jdbcTemplate.update(sql, new Object[]{studentimagepath,studentId});
	}
	
	public Student findStudentByStudentid(String studentId)
	{
		final Student student = new Student();
		String sql = "select * from student where studentid = ?";
		
		jdbcTemplate.query(sql, new Object[]{studentId},
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						
						student.setGrade(rs.getString("grade"));
						student.setImagePath(rs.getString("imagepath"));
						student.setMail(rs.getString("mail"));
						student.setName(rs.getString("name"));
						student.setPhone(rs.getString("phone"));
						student.setSex(rs.getString("sex"));
						student.setStudentID(rs.getString("studentid"));
	
					}
				});
		return student;
	}
	
	public ArrayList<Student> getAllStudent()
	{
		final ArrayList<Student> allStudent = new ArrayList<Student>();
		String sql = "SELECT * from student ORDER BY id DESC";
		jdbcTemplate.query(sql, 
				new RowCallbackHandler() {

					@Override
					public void processRow(ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						Student student = new Student();
						student.setGrade(rs.getString("grade"));
						student.setImagePath(rs.getString("imagepath"));
						student.setMail(rs.getString("mail"));
						student.setName(rs.getString("name"));
						student.setPhone(rs.getString("phone"));
						student.setSex(rs.getString("sex"));
						student.setStudentID(rs.getString("studentid"));
						allStudent.add(student);
					}
				});
		return allStudent;
	}
 
}
