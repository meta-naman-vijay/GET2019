package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseConnection;
import com.dao.DatabaseHelper;
import com.dao.Query;
import com.pojo.Student;

@WebServlet("/ShowStudentDetail")
public class ShowStudentDetail extends HttpServlet {
   
     /**
     * 
     */
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listOfStudents=DatabaseHelper.getAllStudents();
        displayStudent(listOfStudents, response);
    }

    
    private void displayStudent(List<Student> listOfStudents,HttpServletResponse response) throws IOException
    {
        System.out.println("Hello12");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Student ID</th>");
		out.println("<th>First Name </th>");
		out.println("<th>Last Name </th>");
		out.println("<th> Father's Name </th>");
		out.println("<th> Email ID </th>");
		out.println("<th> Class </th>");
		out.println("<th> Age </th>");
		out.println("<th>EDIT</th>");
		out.println("</tr>");
		List<Student> studentList=DatabaseHelper.getAllStudents();
		Student student=null;
		for(int index=0;index<studentList.size();index++){
			student=studentList.get(index);
			
			out.println("<tr>");
			out.println("<td><input type=hidden name=student_id value="+student.getStudentId()+">"+student.getStudentId()+"</td>");
			
			out.println("<td><input type=hidden name=first_name value="+student.getFirstName()+">"+student.getFirstName()+"</td>");
			out.println("<td><input type=hidden name=last_name value="+student.getLastName()+">"+student.getLastName()+"</td>");
			out.println("<td><input type=hidden name=father_name value="+student.getFatherName()+">"+student.getFatherName()+"</td>");
			out.println("<td><input type=hidden name=email value="+student.getEmail()+">"+student.getEmail()+"</td>");
			out.println("<td><input type=hidden name='class' value="+student.getStudentClass()+">"+student.getStudentClass()+"</td>");
			out.println("<td><input type=hidden name=age value="+student.getAge()+">"+student.getAge()+"</td>");
			out.println("<td><a href='EditStudentServlet?student_id="+student.getStudentId()+"'>EDIT</a></td>");
		
			out.println("</tr>");
			
			
		}
		out.println("</table>");
    }
}

