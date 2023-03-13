package com.lcwd.mvc.SpringMvcProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    public String name;
    public int empId;
    public String phone;
    @JsonIgnore
    public String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //@JsonIgnore
    @JsonProperty
    public String getDept() {
        return dept;
    }
    //@JsonProperty
    @JsonIgnore
    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", phone='" + phone + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
