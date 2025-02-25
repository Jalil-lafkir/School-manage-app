package com.example.models;

import java.util.ArrayList;


public class Student  {

    private String id;
    private String name;
    private String email;
    private Float finalGarde;
    ArrayList<Module> student_modules ;


    public Student() {
        
    }

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.finalGarde = 0.00f;
        this.student_modules = new ArrayList<>();
    }

    

    public Student(String id, String name, String email, ArrayList<Module> student_modules) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.student_modules = student_modules;
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
    public Float getFinalGarde() {
        return finalGarde;
    }
    public ArrayList<Module> getStudent_modules() {
        return student_modules;
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
    public void setFinalGarde(Float finalGarde) {
        this.finalGarde = finalGarde;
    }
    public void setStudent_modules(ArrayList<Module> student_modules) {
        this.student_modules = student_modules;
    }


    public void addModule(Module module){
        this.student_modules.add(module);
    }
    public void removeModule(Module module){
        this.student_modules.remove(module);
    }

    @Override
    public String toString(){
        return "The student '" + this.name + "' with the id '" + this.id + "' and email '" + this.email + "' is registered in " + this.student_modules.size() + " modules";
    }
}