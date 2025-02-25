package com.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.example.Database.Tabels;
import com.example.models.Session;
import com.example.schemas.Schema;
import com.example.services.MainService;

@Path("/session")
public class SessionController {

    MainService<Session> service = new MainService<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Session> getAllSessions(Schema.Request<Session> request) {
        return service.handleGetAllObjects(request, Tabels.sessions);
    }

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Session> getSession(Schema.Request<Session> request , @QueryParam("token") String token) {
         if (request == null) {
            request = new Schema.Request<Session>();
            request.setToken(token);
        }
        return service.handleGetObject(request, Tabels.sessions);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Session> postSession(Schema.Request<Session> request) {
        return service.handlePostObject(request, Tabels.sessions);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Session> putSession(Schema.Request<Session> request) {
        return service.handlePutObject(request, Tabels.sessions);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Session> deleteSession(Schema.Request<Session> request) {
        return service.handleDeleteObject(request, Tabels.sessions);
    }
}
