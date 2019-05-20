package com.ssm.bean.employee;

import java.util.Date;

public class Employee {
    private String empId;

    private String empName;

    private String sex;

    private String idCode;

    private String birthday;

    private String joinDate;

    private String status;

    private String education;

    private String degree;

    private String major;

    private String graduateSchool;

    private String educationForm;

    private String departmentId;

    private Department department;

    public Employee(String empId, String empName, String sex, String idCode, String birthday, String joinDate, String status, String education, String degree, String major, String graduateSchool, String educationForm, String departmentId, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.sex = sex;
        this.idCode = idCode;
        this.birthday = birthday;
        this.joinDate = joinDate;
        this.status = status;
        this.education = education;
        this.degree = degree;
        this.major = major;
        this.graduateSchool = graduateSchool;
        this.educationForm = educationForm;
        this.departmentId = departmentId;
        this.department = department;
    }

    public Employee() {
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", sex='" + sex + '\'' +
                ", idCode='" + idCode + '\'' +
                ", birthday='" + birthday + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", status='" + status + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", major='" + major + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", educationForm='" + educationForm + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", department=" + department +
                '}';
    }
}