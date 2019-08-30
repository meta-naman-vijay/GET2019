package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;
import com.pojo.Student;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String firstName=req.getParameter("first_name");
		String lastName=req.getParameter("last_name");
		out.println("<table border=1>");
		out.println("<tr>");
		out.println("<th>Student ID</th>");
		out.println("<th>First Name </th>");
		out.println("<th>Last Name </th>");
		out.println("<th> Father's Name </th>");
		out.println("<th> Email ID </th>");
		out.println("<th> Class </th>");
		out.println("<th> Age </th>");
		out.println("<th> Edit Details </th>");
		out.println("</tr>");
		//searching by first Name and last name
		if (req.getParameter("search_by_name") != null) {
			List<Student> studentList=DatabaseHelper.searchStudentByName(req.getParameter("first_name"),req.getParameter("last_name"));
			Student student=null;
			for(int index=0;index<studentList.size();index++){
				student=studentList.get(index);
				out.println("<form action='EditStudent' method='GET' >");
				out.println("<tr>");
				out.println("<td><input type=hidden name=student_id value="+student.getStudentId()+">"+student.getStudentId()+"</td>");
				out.println("<td><input type=hidden name=first_name value="+student.getFirstName()+">"+student.getFirstName()+"</td>");
				out.println("<td><input type=hidden name=last_name value="+student.getLastName()+">"+student.getLastName()+"</td>");
				out.println("<td><input type=hidden name=father_name value="+student.getFatherName()+">"+student.getFatherName()+"</td>");
				out.println("<td><input type=hidden name=email value="+student.getEmail()+">"+student.getEmail()+"</td>");
				out.println("<td><input type=hidden name='class' value="+student.getStudentClass()+">"+student.getStudentClass()+"</td>");
				out.println("<td><input type=hidden name=age value="+student.getAge()+">"+student.getAge()+"</td>");
				out.println("<td><input type=submit  value='Update '/> </td>");
				out.println("</tr>");
				out.println("</form>");
				
			}
			//searching by class	
		}else if(req.getParameter("search_by_class") != null){
			List<Student> studentList=DatabaseHelper.searchStudentByClass(Integer.parseInt(req.getParameter("class")));
			Student student=null;
			for(int index=0;index<studentList.size();index++){
				student=studentList.get(index);
				out.println("<form action='EditStudent' method='GET' >");
				out.println("<tr>");
				out.println("<td><input type=hidden name=student_id value="+student.getStudentId()+">"+student.getStudentId()+"</td>");
				out.println("<td><input type=hidden name=first_name value="+student.getFirstName()+">"+student.getFirstName()+"</td>");
				out.println("<td><input type=hidden name=last_name value="+student.getLastName()+">"+student.getLastName()+"</td>");
				out.println("<td><input type=hidden name=father_name value="+student.getFatherName()+">"+student.getFatherName()+"</td>");
				out.println("<td><input type=hidden name=email value="+student.getEmail()+">"+student.getEmail()+"</td>");
				out.println("<td><input type=hidden name='class' value="+student.getStudentClass()+">"+student.getStudentClass()+"</td>");
				out.println("<td><input type=hidden name=age value="+student.getAge()+">"+student.getAge()+"</td>");
				out.println("<td><input type=submit  value='Update '/> </td>");
				out.println("</tr>");
				out.println("</form>");
			}
			out.println("</table>");
		out.close();
		}
	}
}
