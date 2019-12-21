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
 * ��ʦ��servlet
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
	
	//��ʦ��¼����
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String t_name = request.getParameter("t_name");
		String t_password = request.getParameter("t_password");
		String checkcode = request.getParameter("checkcode");
		//��session��ȡ��һ������֤��
		String checkcode1 = (String)request.getSession().getAttribute("checkcode");
		
		//Ϊ�˱�֤��֤��ʹ��һ�Σ���session�е���֤�����
		request.getSession().removeAttribute("checkcode");
		//У��һ������֤��
		if(!checkcode.equalsIgnoreCase(checkcode1)) {
			//��֤�����
			request.setAttribute("msg_yzm", "��֤�����");
			request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
			return;
		}
		
		TeacherService teacherService = new  TeacherService();
		Teacher teacher=null;
		try {
			teacher = teacherService.getTeacherByName(t_name);
			if(teacher != null) {
				if(teacher.getT_state() == 0) {
					//û�����ͨ��
					
					request.setAttribute("msg_shenhe", "��ȴ�����Ա�����");
					request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
					return;
				}
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//��װ���ݣ����е����ݷ�װ�����У�
		Teacher teacher1 = new Teacher();
		teacher1.setT_name(t_name);
		teacher1.setT_password(t_password);
		
		//��������
		try {
			Teacher existTeacher = teacherService.login(teacher1);
			
			if(existTeacher == null) {
				//��½ʧ�� ��request���б��������Ϣ
				request.setAttribute("msg_mima", "�û������������");
				request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);				
			}else {
				//��½�ɹ�
				//�����û���Ϣ���Ự��
				HttpSession session = request.getSession();
				session.setAttribute("existTeacher", existTeacher);
				//һ��ʹ���ض�����ת��һ���µ�ҳ��
				response.sendRedirect("/jingsaiguanli/teacher/index.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	//����Ա��¼����
		public void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setCharacterEncoding("UTF-8");
			String t_name = request.getParameter("t_name");
			String t_password = request.getParameter("t_password");
			String checkcode = request.getParameter("checkcode");
			//��session��ȡ��һ������֤��
			String checkcode1 = (String)request.getSession().getAttribute("checkcode");
			
			//Ϊ�˱�֤��֤��ʹ��һ�Σ���session�е���֤�����
			request.getSession().removeAttribute("checkcode");
			//У��һ������֤��
			if(!checkcode.equalsIgnoreCase(checkcode1)) {
				//��֤�����
				request.setAttribute("msg_yzm", "��֤�����");
				request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);
				return;
			}
			
			AdministratorService administratorService = new  AdministratorService();			
			//��װ���ݣ����е����ݷ�װ�����У�
			Administrator administrator = new Administrator();
			administrator.setA_username(t_name);
			administrator.setA_password(t_password);
			
			//��������
			try {
				Administrator existAdministrator = administratorService.login(administrator);
				
				if(existAdministrator == null) {
					//��½ʧ�� ��request���б��������Ϣ
					request.setAttribute("msg_mima", "�û������������");
					request.getRequestDispatcher("/teacher/login.jsp").forward(request, response);				
				}else {
					//��½�ɹ�
					//�����û���Ϣ���Ự��
					HttpSession session = request.getSession();
					session.setAttribute("existAdministrator", existAdministrator);
					//һ��ʹ���ض�����ת��һ���µ�ҳ��
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
				response.getWriter().write("<font color='red'>�û���������</font>");
				return;
			}else {
				response.getWriter().write("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
