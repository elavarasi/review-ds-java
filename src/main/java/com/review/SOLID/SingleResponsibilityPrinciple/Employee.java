package com.review.SOLID.SingleResponsibilityPrinciple;

public class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void calculateTax() {
        // code to calcualte tax
    }

    public void save() {
        //Save user info to a DB
    }


    private String name;
    private String role;
    private String tax;
    private String salary;

}
