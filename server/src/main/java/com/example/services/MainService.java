package com.example.services;


import java.util.ArrayList;

import com.example.schemas.Schema;
import com.example.Database.Operations;



public class MainService<Type> {

    Schema.Response<Type> response ;
    public MainService(){
        this.response = new Schema.Response<Type>();
    }

    public Schema.Response<Type> handleGetAllObjects(Schema.Request<Type> request , ArrayList<Type> DataArrayList) {
        response.setMessage("All Objects : " + DataArrayList.size());
        response.setObjects(DataArrayList);
        return response;
    }


    public Schema.Response<Type> handlePostObject(Schema.Request<Type> request , ArrayList<Type> DataArrayList) {
        Type object = request.getObject();
        Boolean status = Operations.Insert(DataArrayList,object);
        if (status) {
            response.setMessage("Object Added Successfully");
            response.setObject(object);
        } else {
            response.setMessage("Error!");
        }
        return response;
    }

    public Schema.Response<Type> handleGetObject(Schema.Request<Type> request , ArrayList<Type> DataArrayList) {
        String token = request.getToken();
        Type object = Operations.SelectOne(DataArrayList, token);
        if (object != null) {
            response.setMessage(object.toString());
            response.setObject(object);
        }else{
            response.setMessage("Oject Not Found!");
            response.setObject(null);
        }
        return response;
    }

    public Schema.Response<Type> handlePutObject(Schema.Request<Type> request , ArrayList<Type> DataArrayList) {
        Type object = request.getObject();
        Boolean status = Operations.Update(DataArrayList, object);
        if (status) {
            response.setMessage("Object Updated Successfully");
            response.setObject(object);
        } else {
            response.setMessage("Error!");
        }
        return response;
    }

    public Schema.Response<Type> handleDeleteObject(Schema.Request<Type> request , ArrayList<Type> DataArrayList) {
        Type object = request.getObject();
        Boolean status = Operations.Delete(DataArrayList, object);
        if (status) {
            response.setMessage("Object Deleted Successfully");
            response.setObject(object);
        } else {
            response.setMessage("Error!");
        }
        return response;
    }
    
}
