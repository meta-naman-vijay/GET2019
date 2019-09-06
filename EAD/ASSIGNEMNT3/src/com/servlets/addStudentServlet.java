package com.servlets;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import com.dao.DatabaseHelper;
import com.pojo.Student;
@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    public void doGet (HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String father_name = req.getParameter("father_name");
		String email = req.getParameter("email");
		int studentClass = Integer.parseInt(req.getParameter("studentClass").toString());
		int age = Integer.parseInt(req.getParameter("age").toString());
		Student student=new Student();
		student.setFirstName(first_name);
	 student.setLastName(last_name);
	 student.setFatherName(father_name);
	 student.setEmail(email);
	 student.setStudentClass(studentClass);
	 student.setAge(age);
		int insert_Student;
		insert_Student=DatabaseHelper.addStudent(student);
		if(insert_Student==1062)
		{
		    out.println("Email ID already in use");
		}
		else if(insert_Student==1){
 		      out.println("Successfully insert student data");}
 	else
     {
 		         out.println("Some error occured");
     }
   
  }
}
