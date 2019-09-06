package com.dao;

public class Query {

        public static String addStudent(){
            String query="INSERT INTO student(first_name,last_name,father_name,email,class,age) values(?,?,?,?,?,?);";
            return query;
        }
        public static String showStudents(){
            String query="SELECT * FROM student;";
            return query;
        }
        public static String getStudentById(){
            String query="select * from student where student_id=?";
            return query;
        }
        
        public static String updateStudent(){
            String query="update student SET first_name=?,last_name=?,father_name=?,email=?,class=?,age=? where student_id=?";
            return query;
        }
		public static String searchStudentByCLass() {
			String query="SELECT student_id,first_name,last_name,father_name,email,class,age FROM student WHERE class=?";
			return query;
		}
}
