package com.example.sherif.e_fakkaokversion1.Models;

public class Branch {

    private String id ,name ,phone ,address ,username ,password  ,company_id ;
    private boolean blocked;
    private double points;
    private Vendor company;


    public Branch(String id, String name, String phone, String address, String username, String password, String company_id, boolean blocked, double points, Vendor company) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.company_id = company_id;
        this.blocked = blocked;
        this.points = points;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Vendor getCompany() {
        return company;
    }

    public void setCompany(Vendor company) {
        this.company = company;
    }
}
