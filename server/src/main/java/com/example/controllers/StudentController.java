package com.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.example.Database.Tabels;
import com.example.models.Student;
import com.example.schemas.Schema;
import com.example.services.MainService;


@Path("/student")
public class StudentController {

    MainService<Student> service = new MainService<Student>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Student> getAllStudent(Schema.Request<Student> request) {
        Schema.Response<Student> response = service.handleGetAllObjects(request , Tabels.students);
        return response;
    }

    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Student> getStudent(Schema.Request<Student> request , @QueryParam("token") String token) {
        if (request == null) {
            request = new Schema.Request<Student>();
            request.setToken(token);
        }
        Schema.Response<Student> response = service.handleGetObject(request , Tabels.students);
        return response;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Student> postStudent(Schema.Request<Student> request) {
        Schema.Response<Student> response = service.handlePostObject(request , Tabels.students);
        return response;  
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Student> putStudent(Schema.Request<Student> request) {

        Schema.Response<Student> response = service.handlePutObject(request , Tabels.students);
        return response;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Schema.Response<Student> deleteStudent(Schema.Request<Student> request) {
        Schema.Response<Student> response = service.handleDeleteObject(request , Tabels.students);
        return response;
    }  
}
