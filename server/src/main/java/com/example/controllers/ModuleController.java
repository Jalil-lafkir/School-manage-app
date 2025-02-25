package com.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.example.Database.Tabels;
import com.example.models.Module;
import com.example.schemas.Schema;
import com.example.services.MainService;

@Path("/module")
public class ModuleController {

    MainService<Module> service = new MainService<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Module> getAllModules(Schema.Request<Module> request) {
        return service.handleGetAllObjects(request, Tabels.modules);
    }

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Module> getModule(Schema.Request<Module> request , @QueryParam("token") String token) {
         if (request == null) {
            request = new Schema.Request<Module>();
            request.setToken(token);
        }
        return service.handleGetObject(request, Tabels.modules);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Module> postModule(Schema.Request<Module> request) {
        return service.handlePostObject(request, Tabels.modules);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Module> putModule(Schema.Request<Module> request) {
        return service.handlePutObject(request, Tabels.modules);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Module> deleteModule(Schema.Request<Module> request) {
        return service.handleDeleteObject(request, Tabels.modules);
    }
}
