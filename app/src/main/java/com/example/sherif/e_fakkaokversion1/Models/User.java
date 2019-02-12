package com.example.sherif.e_fakkaokversion1.Models;

public class User {

    private String id ,name ,phone ,mail ,username ,password ,created_by ,act_code ,date;
    private boolean activited ,blocked;
    private double points;
    private double free;

    public User(String id, String name, String phone, String mail, String username, String password, String created_by, String act_code, String date, boolean activited, boolean blocked, double points, double free) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.created_by = created_by;
        this.act_code = act_code;
        this.date = date;
        this.activited = activited;
        this.blocked = blocked;
        this.points = points;
        this.free = free;
    }


    public double getFree() {
        return free;
    }

    public void setFree(double free) {
        this.free = free;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getAct_code() {
        return act_code;
    }

    public void setAct_code(String act_code) {
        this.act_code = act_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isActivited() {
        return activited;
    }

    public void setActivited(boolean activited) {
        this.activited = activited;
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
}
