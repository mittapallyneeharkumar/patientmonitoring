package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import forms.Hospital;
import forms.User;

public class DB {

	public int AddUser(User user)
    {
        int result=0;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patientmonitoringsystem","root","root");
                PreparedStatement stmt=con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setLong(1,user.getUid());
                stmt.setString(2,user.getEmail());
                stmt.setString(3, user.getMobile());
                stmt.setString(4,user.getName());
                stmt.setString(5,user.getDob());
                stmt.setString(6,user.getAddress());
                stmt.setString(7,user.getGender());
                stmt.setString(8,user.getBp());
                stmt.setInt(9,user.getHeight());
                stmt.setInt(10,user.getWeight());
                stmt.setFloat(11,user.getBmi());
                stmt.setBoolean(12, false);
                result=stmt.executeUpdate();            
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
            return result;
    }
	public User SearchUserById(User user) {
	    User foundUser = null;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patientmonitoringsystem", "root", "root");

	        String query = "SELECT * FROM patient WHERE uid = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setLong(1, user.getUid());

	        ResultSet rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            foundUser = new User(); 

	            foundUser.setUid(rs.getLong("uid"));
	            foundUser.setEmail(rs.getString("email"));
	            foundUser.setMobile(rs.getString("mobile"));
	            foundUser.setName(rs.getString("name"));
	            foundUser.setDob(rs.getString("dob"));
	            foundUser.setAddress(rs.getString("address"));
	            foundUser.setGender(rs.getString("gender"));
	            foundUser.setBp(rs.getString("bp"));
	            foundUser.setHeight(rs.getInt("height"));
	            foundUser.setWeight(rs.getInt("weight"));
	            foundUser.setBmi(rs.getFloat("bmi"));
	            foundUser.setCurrentStatus(rs.getBoolean("currentStatus"));
	        }
	        
	        con.close(); 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return foundUser;
	}
	public int addHospital(Hospital hospital) {
	    int result = 0;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/patientmonitoringsystem", "root", "root");
	        PreparedStatement stmt = con.prepareStatement("INSERT INTO hospital (hid, name, address, phoneNumber, uid) VALUES (?, ?, ?, ?, ?)");
	        
	        stmt.setInt(1, hospital.getHid());
	        stmt.setString(2, hospital.getName());
	        stmt.setString(3, hospital.getAddress());
	        stmt.setString(4, hospital.getPhoneNumber());
	        stmt.setLong(5, hospital.getUid());

	        result = stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	


}
