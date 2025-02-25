package com.example.schemas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schema {

     public static class Request<Type> {

        @JsonProperty
        private String token;

        @JsonProperty
        private Type object;

        public String getToken() {
            return token;
        }

        public Type getObject() {
            return object;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setObject(Type object) {
            this.object = object;
        }
    }



    
    public static class Response<Type>{

        @JsonProperty
        private String message;

        @JsonProperty
        private Type object;

        @JsonProperty
        private Iterable<Type> objects;

        public String getMessage() {
            return message;
        }

        public Type getObject() {
            return object;
        }

        public Iterable<Type> getObjects() {
            return objects;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public void setObject(Type object) {
            this.object = object;
        }
        public void setObjects(Iterable<Type> objects) {
            this.objects = objects;
        }
    }
    
}
