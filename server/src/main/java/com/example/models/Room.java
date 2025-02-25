package com.example.models;

import com.example.utils.Generator;

public class Room {

    private String id;
    private String name;
    private String type ;// "CourseRoom" || "TdRoom" || "TpRoom";


    public Room() {
    }
    
    public Room(String name , String type) {    
        this.id = Generator.generateRoomId();
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "The room '" + this.name + "' with the id '" + this.id + "' and type '" + this.type + "' is registered in ";
    }
}
