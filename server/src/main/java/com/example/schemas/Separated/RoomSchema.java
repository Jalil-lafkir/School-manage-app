package com.example.schemas.Separated;

import java.util.ArrayList;

import com.example.models.Room;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomSchema {
    
    public static class Request {

        @JsonProperty
        private String token;

        @JsonProperty
        private Room room;

        public String getToken() {
            return token;
        }

        public Room getRoom() {
            return room;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setRoom(Room room) {
            this.room = room;
        }
    }

    public static class Response {

        @JsonProperty
        private String message;

        @JsonProperty
        private Room room;

        @JsonProperty
        private ArrayList<Room> rooms;

        public String getMessage() {
            return message;
        }

        public Room getRoom() {
            return room;
        }

        public ArrayList<Room> getRooms() {
            return rooms;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public void setRooms(ArrayList<Room> rooms) {
            this.rooms = rooms;
        }
    }
}
