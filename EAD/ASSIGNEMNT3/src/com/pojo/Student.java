package com.pojo;

public class Student {
    private int student_id;
    private String first_name;
    private String last_name;
    private String father_name;
    private String email;
    private int studentClass;
    private int age;
   
    public int getStudentId() {
        return student_id;
    }
    public void setStudentId(int student_id) {
        this.student_id = student_id;
    }
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public String getFatherName() {
        return father_name;
    }
    public void setFatherName(String father_name) {
        this.father_name = father_name;
    }
    public String getLastName() {
        return last_name;
    }
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getStudentClass() {
        return studentClass;
    }
    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }

}