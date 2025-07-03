package com.voidmain.pm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voidmain.pm.dao.AppDAO;
import com.voidmain.pm.form.User;
import com.voidmain.pm.service.MailService;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User userForm=new User();

		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		
		String type=request.getParameter("type");

		userForm.setUserName(userName);
		userForm.setAddress(address);
		userForm.setEmail(email);
		userForm.setMobile(mobile);
		userForm.setPassword(password);
		userForm.setType(type);

		if(AppDAO.userRegistration(userForm)==2)
		{
			try {
				MailService.mailsend("Re: Patient Monitoring System","Your Account Password is :"+password, email);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(type.equals("hospital"))
			{
				response.sendRedirect("hospitalregistration.jsp?status=success");
			}
			else
			{
				response.sendRedirect("patientregistration.jsp?status=success");
			}
		}
		else
		{
			if(type.equals("hospital"))
			{
				response.sendRedirect("hospitalregistration.jsp?status=User Name Allready Registred");
			}
			else
			{
				response.sendRedirect("patientregistration.jsp?status=User Name Allready Registred");
			}
		}
	}
}
