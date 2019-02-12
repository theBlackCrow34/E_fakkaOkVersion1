package com.example.sherif.e_fakkaokversion1.Models;

import java.util.List;

public class Vendor {

    private String id ,name ,phone ,mail ,username ,password ,indastry ,contacts;
    private double points;
    private boolean activited;
    private List<Branch>  branches_list ;

    public Vendor(String id, String name, String phone, String mail, String username, String password, String indastry, String contacts, double points, boolean activited, List<Branch> branches_list) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.indastry = indastry;
        this.contacts = contacts;
        this.points = points;
        this.activited = activited;
        this.branches_list = branches_list;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getIndastry() {
        return indastry;
    }

    public void setIndastry(String indastry) {
        this.indastry = indastry;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public boolean isActivited() {
        return activited;
    }

    public void setActivited(boolean activited) {
        this.activited = activited;
    }

    public List<Branch> getBranches_list() {
        return branches_list;
    }

    public void setBranches_list(List<Branch> branches_list) {
        this.branches_list = branches_list;
    }
}
