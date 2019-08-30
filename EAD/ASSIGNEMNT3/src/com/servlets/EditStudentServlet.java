package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;
import com.pojo.Student;
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int student_id=Integer.parseInt(request.getParameter("student_id"));
        Student student=DatabaseHelper.getStudent(student_id);
        System.out.println("HELLOWORLD3");
        display(student,response);
    }
    private void display(Student student,HttpServletResponse response) throws IOException
    {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Employee Details</title>");
        out.println("</head>");
        out.println("<body style=\"background-color:#D8D4CC;\">");
        out.println("<h1 align=\"center\">Edit Employee Details!!</h1>");
        out.println("<form action=\"UpdateStudentServlet\">");
        out.println("<input type=\"hidden\" name=\"student_id\" value=\""+student.getStudentId()+"\"/>");
        out.println("<table align=\"center\" cellpadding=\"6\">");
        out.println("<tr>");
        out.println("<td><b>First Name</b></td>");
        out.println("<td><input type=\"text\" name=\"first_name\" value=\""+student.getFirstName()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Last Name</b></td>");
        out.println("<td><input type=\"text\" name=\"last_name\" value=\""+student.getLastName()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Father Name</b></td>");
        out.println("<td><input type=\"text\" name=\"father_name\" value=\""+student.getFatherName()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Email</b></td>");
        out.println("<td><input type=\"text\" name=\"email\" value=\""+student.getEmail()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Class</b></td>");
        out.println("<td><input type=\"text\" name=\"studentClass\" value=\""+student.getStudentClass()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><b>Age</b></td>");
        out.println("<td><input type=\"text\" name=\"age\" value=\""+student.getAge()+"\"/></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"Save Info\"/></td>");
        out.println("</tr>");
        out.println("</form>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
    }
    

}
