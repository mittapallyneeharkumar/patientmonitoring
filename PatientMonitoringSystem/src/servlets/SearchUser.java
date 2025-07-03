package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import forms.User;

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		User founduser=null;
		long uid = Long.parseLong(request.getParameter("uid"));
		user.setUid(uid);
		DB db=new DB();
		founduser=db.SearchUserById(user);
		PrintWriter pw=response.getWriter();
		if(founduser==null)
		{
			pw.println("no patient");
		}
		else
		{
			
			pw.println(founduser.getUid());
			pw.println(founduser.getName());
		}
	}

}
