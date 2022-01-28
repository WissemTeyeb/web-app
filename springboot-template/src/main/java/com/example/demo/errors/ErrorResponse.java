package com.example.demo.errors;

import java.util.Date;

public class ErrorResponse {
    public String description ;
    public String url ;
    public Date timeStamp;

    public ErrorResponse() {
        this.timeStamp=new Date();

    }

    public ErrorResponse(String message, String url) {
        this();
        this.description = message;
        this.url = url;


    }
    public String getDescription() {
        return description;
    }
    public Date getTimeStamp() {
        return timeStamp;
    }
    public void setDescription(String message) {
        this.description = message;
    }
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
