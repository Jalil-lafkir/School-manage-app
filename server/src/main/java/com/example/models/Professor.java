package com.example.models;

import java.util.ArrayList;

import com.example.utils.Generator;

public class Professor {

    private String id;
    private String name;
    private String email;
    private Float mountSalary;
    private ArrayList<Session> professor_sessions;
    

    public Professor() {
        
    }
    public Professor(String name, String email) {
        this.id = Generator.generateProfessorId();
        this.name = name;
        this.email = email;
        this.mountSalary = 0.00f;
        this.professor_sessions = new ArrayList<>();
    }

    

    public Professor(String id , String name, String email, Float mountSalary,ArrayList<Session> professor_sessions) {
        this.name = name;
        this.email = email;
        this.professor_sessions = professor_sessions;
    }



    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Float getMountSalary() {
        return mountSalary;
    }
    public ArrayList<Session> getProfessor_sessions() {
        return professor_sessions;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMountSalary(Float mountSalary) {
        this.mountSalary = mountSalary;
    }
    public void setProfessor_sessions(ArrayList<Session> professor_sessions) {
        this.professor_sessions = professor_sessions;
    }

    @Override
    public String toString(){
        return "The professor '" + this.name + "' with the id '" + this.id + "' and email '" + this.email + "' teach '"+ this.professor_sessions.size() + "' per week!";
    }
}
