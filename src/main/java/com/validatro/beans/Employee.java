package com.validatro.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Employee {
    @NotNull(message = "employee name should not null")
    @NotEmpty(message = "employee name sholud nor empty")
    protected  String name;
    @Email
    protected String emailid;
    @Pattern(regexp="^[0-9]*$",message = "enter vaild pine number")
    protected String mobileno;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
