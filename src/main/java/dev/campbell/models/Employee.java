package dev.campbell.models;

import java.math.BigDecimal;

public class Employee {

    //private variables for Employee model
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private BigDecimal reimbursement;
    private int department;
    private int directSupervisorId;
    private String email;

    public Employee() {
    }

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(int id, String firstName, String lastName, String username, BigDecimal reimbursement, int department, int directSupervisorId, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.reimbursement = reimbursement;
        this.department = department;
        this.directSupervisorId = directSupervisorId;
        this.email = email;
    }

    public Employee(int id, String firstName, String lastName, String username, String password, BigDecimal reimbursement, int department, int directSupervisorId, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.reimbursement = reimbursement;
        this.department = department;
        this.directSupervisorId = directSupervisorId;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(BigDecimal reimbursement) {
        this.reimbursement = reimbursement;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDirectSupervisorId() {
        return directSupervisorId;
    }

    public void setDirectSupervisorId(int directSupervisorId) {
        this.directSupervisorId = directSupervisorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reimbursement=" + reimbursement +
                ", department=" + department +
                ", directSupervisorId=" + directSupervisorId +
                ", email='" + email + '\'' +
                '}';
    }
}
