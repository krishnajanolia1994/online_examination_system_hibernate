package com.krishna;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Student_login extends HttpServlet {
	

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int redirect ;
		PrintWriter pr=res.getWriter();
		Singin_servicess serv =new Singin_servicess();
		try {
			redirect=serv.sevice(req,res,"student_login_table");
			if(redirect==1)
			{
				String email=req.getParameter("Email_Address");
				HttpSession se=req.getSession();
				String temp1,temp2;
				int index=email.indexOf("@");
				temp1=email.substring(0, index);
				temp2=email.substring(index+1, email.length()-1);
				email=temp1+temp2;
				se.setAttribute("email_of_student", email);
				res.sendRedirect("display.jsp");
			}
			else
			{
				pr.println(redirect);
				//res.sendRedirect("index1.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
