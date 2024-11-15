package com.app_flutter_backend.interfaces.service;

import java.util.List;

import com.app_flutter_backend.models.entity.Users;

public class IUserServiceReturn {
    int code;
    Object message;
    Users response ;
    List<Users> responseArray ;

    
    public IUserServiceReturn(int code, Object message, Users response) {
        this.code = code;
        this.message = message;
        this.response = response;
    }

    public IUserServiceReturn(int code, Object message, List<Users> responseArray) {
        this.code = code;
        this.message = message;
        this.responseArray = responseArray;
    }
    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public Object getMessage() {
        return message;
    }
    public void setMessage(Object message) {
        this.message = message;
    }
    public Users getResponse() {
        return response;
    }
    public void setResponse(Users response) {
        this.response = response;
    }
    public List<Users> getResponseArray() {
        return responseArray;
    }
    public void setResponseArray(List<Users> responseArray) {
        this.responseArray = responseArray;
    }

    
}