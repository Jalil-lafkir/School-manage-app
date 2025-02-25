package com.example.Database.Separated;

import java.util.ArrayList;

import com.example.models.Room;

public class RoomTable {


    ArrayList<Room> rooms = new ArrayList<Room>();

    public RoomTable() {}

    public ArrayList<Room> readAllRooms() {
       return rooms;
    }

    public void createRoom(Room room) {
        this.rooms.add(room);
    }

    public Room readRoom(String id) {
        for (Room room : this.rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public void updateRoom(Room room) {
        for (Room dbroom : this.rooms) {
            if (dbroom.getId().equals(room.getId())) {
                rooms.remove(dbroom);
                rooms.add(room);
                return;
            }
        }
    }


    public void deleteRoom(Room room) {
        for (Room dbroom : this.rooms) {
            if (dbroom.getId().equals(room.getId())) {
                rooms.remove(dbroom);
                return;
            }
        }
    }

    
    
}
