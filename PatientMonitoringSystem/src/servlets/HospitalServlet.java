package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import forms.Hospital;

@WebServlet("/HospitalServlet")
public class HospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hospital hospital=new Hospital();
		int result=0;
		
		int hid = Integer.parseInt(request.getParameter("hid"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		long uid = Long.parseLong(request.getParameter("uid"));

		hospital.setHid(hid);
		hospital.setName(name);
		hospital.setAddress(address);
		hospital.setPhoneNumber(phoneNumber);
		hospital.setUid(uid);
		DB db=new DB();
		result=db.addHospital(hospital);
		PrintWriter pw=response.getWriter();
		if (result==1)
		{
			
			pw.println("registered succesfully");
		}
		else
		{
			pw.println("not registered succesfully");
		}
			
	}

}
