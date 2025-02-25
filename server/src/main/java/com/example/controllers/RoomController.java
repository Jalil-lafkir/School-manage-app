package com.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.example.Database.Tabels;
import com.example.models.Room;
import com.example.schemas.Schema;
import com.example.services.MainService;

@Path("/room")
public class RoomController {

    MainService<Room> service = new MainService<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Room> getAllRooms(Schema.Request<Room> request) {
        return service.handleGetAllObjects(request, Tabels.rooms);
    }

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Room> getRoom( Schema.Request<Room> request , @QueryParam("token") String token) {
         if (request == null) {
            request = new Schema.Request<Room>();
            request.setToken(token);
        }
        return service.handleGetObject(request, Tabels.rooms);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Room> postRoom(Schema.Request<Room> request) {
        return service.handlePostObject(request, Tabels.rooms);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Room> putRoom(Schema.Request<Room> request) {
        return service.handlePutObject(request, Tabels.rooms);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Room> deleteRoom(Schema.Request<Room> request) {
        return service.handleDeleteObject(request, Tabels.rooms);
    }
}
