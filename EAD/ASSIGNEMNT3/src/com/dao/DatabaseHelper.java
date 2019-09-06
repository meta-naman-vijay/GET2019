package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Student;



public class DatabaseHelper {

 public static int addStudent(Student student){
 
 String query=Query.addStudent();
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query); )
                {
                statement.setString(1,student.getFirstName());
                statement.setString(2,student.getLastName());
                statement.setString(3,student.getFatherName());
                statement.setString(4,student.getEmail());
                statement.setInt(5,student.getStudentClass());
                statement.setInt(6,student.getAge());
                
                int i=statement.executeUpdate();
                
                if(i==1)
                    return 1;
                }
       
        catch (SQLException sqlException) {
         //sqlException.printStackTrace();
            return sqlException.getErrorCode();
            }
        return 0;   
     }
 public static List<Student> getAllStudents()
 {
     System.out.println("HEllo1");
     List<Student> listOfStudents=new ArrayList<Student>();
     String query=Query.showStudents();
     try(Connection connection=DatabaseConnection.getConnection();
             //Allocate statement object in connection
             PreparedStatement statement = connection.prepareStatement(query); )
     {
         ResultSet result=statement.executeQuery();
         listOfStudents = getStudents(result);
         
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return listOfStudents;
 }
 
 public static Student getStudent(int student_id)
 {
     Student student=new Student();
     String query=Query.getStudentById();
     try(Connection connection=DatabaseConnection.getConnection();
             //Allocate statement object in connection
             PreparedStatement statement = connection.prepareStatement(query); )
     {
         statement.setInt(1,student_id);
         ResultSet result=statement.executeQuery();
         student=getStudents(result).get(0);
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return student;
 }
    
 public static List<Student> getStudents(ResultSet result) throws SQLException
 {   
     List<Student> listOfStudents=new ArrayList<Student>();
     try{
     while(result.next())
     {
         int student_id=result.getInt("student_id");
         String first_name=result.getString("first_name");
         String last_name=result.getString("last_name");
         String father_name=result.getString("father_name");
         String email=result.getString("email");
         int age=result.getInt("age");
         int studentClass=result.getInt("class");
         Student student=new Student();
         student.setStudentId(student_id);
         student.setFirstName(first_name);
         student.setLastName(last_name);
         student.setFatherName(father_name);
         student.setEmail(email);
         student.setAge(age);
         student.setStudentClass(studentClass);
         listOfStudents.add(student);
     }
     }catch(SQLException e) {
         e.printStackTrace();
     }
     
    return listOfStudents;
 }

public static int updateStudent(int student_id, String first_name,
        String last_name, String father_name, String email, int studentClass, int age) {
    String query=Query.updateStudent();
    int updatedRows=0;
    try(Connection connection=DatabaseConnection.getConnection();
          //Allocate statement object in connection
            PreparedStatement statement = connection.prepareStatement(query); ){
        try {
           
            statement.setString(1,first_name);
            statement.setString(2,last_name);
            statement.setString(3,father_name);
            statement.setString(4,email);
            statement.setInt(5,studentClass);
            statement.setInt(6,age);
            statement.setInt(7,student_id);
                       
            updatedRows=statement.executeUpdate();
        } 
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            connection.rollback();
        }    
    }
    catch (SQLException exception) {
        exception.printStackTrace();
    }
    return updatedRows;
}
public static List<Student> searchStudentByName(String firstName,String lastName) {
	List<Student> listOfStudents = new ArrayList<Student>();
	try {
		Connection con = DatabaseConnection.getConnection();
		String query = "SELECT student_id,first_name,last_name,father_name,email,class,age FROM student WHERE first_name='"+firstName+"' AND last_name='"+lastName+"'";
		Statement statement = con.createStatement();
		ResultSet studentsData = statement.executeQuery(query);

		Student student = null;
		while (studentsData.next()) {
			student = new Student();
			student.setStudentId(Integer.parseInt(studentsData.getString(1)));
			student.setFirstName(studentsData.getString(2));
			student.setLastName(studentsData.getString(3));
			student.setFatherName(studentsData.getString(4));
			student.setEmail(studentsData.getString(5));
			student.setStudentClass(Integer.parseInt(studentsData
					.getString(6)));
			student.setAge(Integer.parseInt(studentsData.getString(7)));
			listOfStudents.add(student);
		}
		con.close();
	} catch (SQLException sqlException) {
		sqlException.printStackTrace();
	}
	return listOfStudents;
}
/**
 * Method to search student  into database by first class
 * @param studentClass is int type 
 * @return List of students
 */
public static List<Student> searchStudentByClass(int studentClass) {
	List<Student> listOfStudents = new ArrayList<Student>();
	try {
		Connection con = DatabaseConnection.getConnection();
		String query = Query.searchStudentByCLass();
		Statement statement = con.createStatement();
		ResultSet studentsData = statement.executeQuery(query);

		Student student = null;
		while (studentsData.next()) {
			student = new Student();
			student.setStudentId(Integer.parseInt(studentsData.getString(1)));
			student.setFirstName(studentsData.getString(2));
			student.setLastName(studentsData.getString(3));
			student.setFatherName(studentsData.getString(4));
			student.setEmail(studentsData.getString(5));
			student.setStudentClass(Integer.parseInt(studentsData
					.getString(6)));
			student.setAge(Integer.parseInt(studentsData.getString(7)));
			listOfStudents.add(student);
		}
		con.close();
	} catch (SQLException sqlException) {
		sqlException.printStackTrace();
	}
	return listOfStudents;
}
 
}