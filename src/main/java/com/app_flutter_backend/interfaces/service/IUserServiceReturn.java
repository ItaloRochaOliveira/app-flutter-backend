package com.app_flutter_backend.interfaces.service;

public class IUserServiceReturn<Response> {
    int code;
    String message;
    Response response;

    
    public IUserServiceReturn(int code, String message, Response response) {
        this.code = code;
        this.message = message;
        this.response = response;
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
    public void setMessage(String message) {
        this.message = message;
    }
    public Response getResponse() {
        return response;
    }
    public void setResponse(Response response) {
        this.response = response;
    }
}