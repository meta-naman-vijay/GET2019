package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DatabaseHelper;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int student_id = Integer.parseInt(request.getParameter("student_id"));
        String first_name=request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String father_name = request.getParameter("father_name");
        String email = request.getParameter("email");
        int studentClass = Integer.parseInt(request.getParameter("studentClass"));
        int age = Integer.parseInt(request.getParameter("age"));
        PrintWriter out = response.getWriter();
        int updatedRows=DatabaseHelper.updateStudent(student_id,first_name, last_name, father_name,email,studentClass,age);
        if(updatedRows!=0)
        {
            out.println("<script>alert(\"Data updated successfully!!\")</script>");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/ShowStudentDetail");
            dispatcher.include(request, response);
        }
        else
        {
            out.println("<script>alert(\"Data updation failed!!\")</script>");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/EditStudentServlet");
            dispatcher.include(request, response);
        }
    }

   

}
