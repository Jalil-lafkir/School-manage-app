package com.example.schemas.Separated;

import java.util.ArrayList;

import com.example.models.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentSchema {
    

    public static class Request{

        @JsonProperty
        private String token;

        @JsonProperty
        private Student student;

        public String getToken() {
            return token;
        }
        public Student getStudent() {
            return student;
        }

        public void setToken(String token) {
            this.token = token;
        }
        public void setStudent(Student student) {
            this.student = student;
        }

    }

    public static class Response{

        @JsonProperty
        private String message;

        @JsonProperty
        private Student student;

        @JsonProperty
        private ArrayList<Student> students;

        public String getMessage() {
            return message;
        }
        public Student getStudent() {
            return student;
        }
        public ArrayList<Student> getStudents() {
            return students;
        }


        public void setMessage(String message) {
            this.message = message;
        }
        public void setStudent(Student student) {
            this.student = student;
        }
        public void setStudents(ArrayList<Student> students) {
            this.students = students;
        }

    }
}
