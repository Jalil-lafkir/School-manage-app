package com.example.schemas.Separated;

import java.util.ArrayList;

import com.example.models.Module;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ModuleSchema {
    
    public static class Request {

        @JsonProperty
        private String token;

        @JsonProperty
        private Module module;

        public String getToken() {
            return token;
        }

        public Module getModule() {
            return module;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setModule(Module module) {
            this.module = module;
        }
    }

    public static class Response {

        @JsonProperty
        private String message;

        @JsonProperty
        private Module module;

        @JsonProperty
        private ArrayList<Module> modules;

        public String getMessage() {
            return message;
        }

        public Module getModule() {
            return module;
        }

        public ArrayList<Module> getModules() {
            return modules;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setModule(Module module) {
            this.module = module;
        }

        public void setModules(ArrayList<Module> modules) {
            this.modules = modules;
        }
    }
}
