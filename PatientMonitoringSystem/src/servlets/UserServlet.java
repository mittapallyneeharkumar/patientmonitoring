package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DB;
import forms.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            
            long uid = Long.parseLong(request.getParameter("uid"));
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String bp = request.getParameter("bp");
            int height = Integer.parseInt(request.getParameter("height"));
            int weight = Integer.parseInt(request.getParameter("weight"));
            float bmi = Float.parseFloat(request.getParameter("bmi"));

            
            User user = new User();
            user.setUid(uid);
            user.setEmail(email);
            user.setMobile(mobile);
            user.setName(name);
            user.setDob(dob);
            user.setAddress(address);
            user.setGender(gender);
            user.setBp(bp);
            user.setHeight(height);
            user.setWeight(weight);
            user.setBmi(bmi);


            DB db = new DB();
            int status = db.AddUser(user);


            response.setContentType("text/html");
            response.getWriter().write("<h3>" + (status > 0 ? "User added successfully!" : "Failed to add user.") + "</h3>");

        } catch (NumberFormatException e) {
            response.getWriter().write("<h3>Error: Invalid input format.</h3>");
        }
    }
}
