package com.example.models;

import java.util.ArrayList;

import com.example.utils.Generator;

public class Session {

    private String id;
    private String name;
    private String date;
    private String time;
    private String roomId;
    private String professorId;
    private String moduleId;
    private ArrayList<Student> sessionStudents;

    public Session() {
    }

    public Session(String name, String date, String time, String roomId, String professorId, String moduleId) {
        this.id = Generator.generateSessionId();
        this.name = name;
        this.date = date;
        this.time = time;
        this.roomId = roomId;
        this.professorId = professorId;
        this.moduleId = moduleId;
        this.sessionStudents = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getRoomId() {
        return roomId;
    }
    public String getProfessorId() {
        return professorId;
    }
    public String getModuleId() {
        return moduleId;
    }
    public ArrayList<Student> getSessionStudents() {
        return sessionStudents;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }
    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    public void setSessionStudents(ArrayList<Student> sessionStudents) {
        this.sessionStudents = sessionStudents;
    }


    public void addStudent(Student student){
        this.sessionStudents.add(student);
    }
    public void removeStudent(Student student){
        this.sessionStudents.remove(student);
    }

    @Override
    public String toString() {
        return "The session '" + this.name + "' with the id '" + this.id + "' is scheduled for " + this.date + " at " + this.time + " in room " + this.roomId + " and is taught by professor with id " + this.professorId + " for module with id " + this.moduleId + " and has " + this.sessionStudents.size() + " students";
    }
    
}
