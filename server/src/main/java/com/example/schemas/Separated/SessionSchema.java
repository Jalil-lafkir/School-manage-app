package com.example.schemas.Separated;

import java.util.ArrayList;

import com.example.models.Session;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionSchema {
    
    public static class Request {

        @JsonProperty
        private String token;

        @JsonProperty
        private Session session;

        public String getToken() {
            return token;
        }

        public Session getSession() {
            return session;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setSession(Session session) {
            this.session = session;
        }
    }

    public static class Response {

        @JsonProperty
        private String message;

        @JsonProperty
        private Session session;

        @JsonProperty
        private ArrayList<Session> sessions;

        public String getMessage() {
            return message;
        }

        public Session getSession() {
            return session;
        }

        public ArrayList<Session> getSessions() {
            return sessions;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setSession(Session session) {
            this.session = session;
        }

        public void setSessions(ArrayList<Session> sessions) {
            this.sessions = sessions;
        }
    }
}
