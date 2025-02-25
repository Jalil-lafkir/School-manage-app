package com.example.schemas.Separated;

import java.util.ArrayList;

import com.example.models.Professor;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfessorSchema {
    
    public static class Request {

        @JsonProperty
        private String token;

        @JsonProperty
        private Professor professor;

        public String getToken() {
            return token;
        }

        public Professor getProfessor() {
            return professor;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }
    }

    public static class Response {

        @JsonProperty
        private String message;

        @JsonProperty
        private Professor professor;

        @JsonProperty
        private ArrayList<Professor> professors;

        public String getMessage() {
            return message;
        }

        public Professor getProfessor() {
            return professor;
        }

        public ArrayList<Professor> getProfessors() {
            return professors;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setProfessor(Professor professor) {
            this.professor = professor;
        }

        public void setProfessors(ArrayList<Professor> professors) {
            this.professors = professors;
        }
    }
}
