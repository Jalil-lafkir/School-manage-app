package com.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.example.Database.Tabels;
import com.example.models.Professor;
import com.example.schemas.Schema;
import com.example.services.MainService;

@Path("/professor")
public class ProfessorController {

    MainService<Professor> service = new MainService<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Professor> getAllProfessors(Schema.Request<Professor> request) {
        return service.handleGetAllObjects(request, Tabels.professors);
    }

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Professor> getProfessor(Schema.Request<Professor> request ,  @QueryParam("token") String token) {
         if (request == null) {
            request = new Schema.Request<Professor>();
            request.setToken(token);
        }
        return service.handleGetObject(request, Tabels.professors);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Professor> postProfessor(Schema.Request<Professor> request) {
        return service.handlePostObject(request, Tabels.professors);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Professor> putProfessor(Schema.Request<Professor> request) {
        return service.handlePutObject(request, Tabels.professors);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Professor> deleteProfessor(Schema.Request<Professor> request) {
        return service.handleDeleteObject(request, Tabels.professors);
    }
}
