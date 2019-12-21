package com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.domain.Administrator;
import com.domain.ErrorStruct;
import com.domain.Teacher;
import com.service.AdministratorService;
import com.service.TeacherService;

/**
 * 教师的servlet
 */
public class TeacherServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String choice = request.getParameter("choice");
		if("chachong".equals(method)) {
			chachong(request, response);
		}
		if("register".equals(method)) {
			register(request, response);
		}
		if("login".equals(method)) {
			if("teacher".equals(choice)){
			login(request, response);}
			else{
			loginAdmin(request, response);
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//教师登录函数
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String t_name = request.getParameter("t_name");
		String t_password = request.getParameter("t_password");
		String checkcode = request.getParameter("checkcode");
		//从session中取出一次性验证码
		String checkcode1 = (String)request.getSession().getAttribute("checkcode");
		
		//为了保证验证码使用一次，将session中的验证码清空
		request.getSession().removeAttribute("checkcode");
		//校验一次性验证码
		if(!checkcode.equalsIgnoreCase(checkcode1)) {
			//验证码错误
			request.setAttribute("msg_yzm", "验证码错误");
			request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
			return;
		}
		
		TeacherService teacherService = new  TeacherService();
		Teacher teacher=null;
		try {
			teacher = teacherService.getTeacherByName(t_name);
			if(teacher != null) {
				if(teacher.getT_state() == 0) {
					//没有审核通过
					
					request.setAttribute("msg_shenhe", "请等待管理员的审核");
					request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
					return;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//封装数据（表单中的数据封装到类中）
		Teacher teacher1 = new Teacher();
		teacher1.setT_name(t_name);
		teacher1.setT_password(t_password);
		
		//处理数据
		try {
			Teacher existTeacher = teacherService.login(teacher1);
			
			if(existTeacher == null) {
				//登陆失败 向request域中保存错误信息
				request.setAttribute("msg_mima", "用户名或密码错误！");
				request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);				
			}else {
				//登陆成功
				//保存用户信息到会话中
				HttpSession session = request.getSession();
				session.setAttribute("existTeacher", existTeacher);
				//一般使用重定向跳转到一个新的页面
				response.sendRedirect("/jingsaiguanli/teacher/index.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	//管理员登录函数
		public void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setCharacterEncoding("UTF-8");
			String t_name = request.getParameter("t_name");
			String t_password = request.getParameter("t_password");
			String checkcode = request.getParameter("checkcode");
			//从session中取出一次性验证码
			String checkcode1 = (String)request.getSession().getAttribute("checkcode");
			
			//为了保证验证码使用一次，将session中的验证码清空
			request.getSession().removeAttribute("checkcode");
			//校验一次性验证码
			if(!checkcode.equalsIgnoreCase(checkcode1)) {
				//验证码错误
				request.setAttribute("msg_yzm", "验证码错误");
				request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
				return;
			}
			
			AdministratorService administratorService = new  AdministratorService();			
			//封装数据（表单中的数据封装到类中）
			Administrator administrator = new Administrator();
			administrator.setA_username(t_name);
			administrator.setA_password(t_password);
			
			//处理数据
			try {
				Administrator existAdministrator = administratorService.login(administrator);
				
				if(existAdministrator == null) {
					//登陆失败 向request域中保存错误信息
					request.setAttribute("msg_mima", "用户名或密码错误！");
					request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);				
				}else {
					//登陆成功
					//保存用户信息到会话中
					HttpSession session = request.getSession();
					session.setAttribute("existAdministrator", existAdministrator);
					//一般使用重定向跳转到一个新的页面
					response.sendRedirect("/jingsaiguanli/administrator/index.jsp");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t_name = request.getParameter("t_name");
		String t_password = request.getParameter("t_password");
		String t_email = request.getParameter("t_email");
		String t_xueyuan = request.getParameter("t_xueyuan");
		Teacher teacher = new Teacher();
		teacher.setT_name(t_name);
		teacher.setT_password(t_password);
		teacher.setT_email(t_email);
		teacher.setT_xueyuan(t_xueyuan);
		
		TeacherService teacherService = new TeacherService();
		try {
			teacherService.register(teacher);
			response.sendRedirect("/jingsaiguanli/teacher/login.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void chachong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String t_name = request.getParameter("t_name");
		
		TeacherService teacherService = new TeacherService();
		try {
			boolean b = teacherService.chachong(t_name);
			t_name = t_name.trim();
			if(b!=true || t_name.equals("")) {
				response.getWriter().write("<font color='red'>用户名不可用</font>");
				return;
			}else {
				response.getWriter().write("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
