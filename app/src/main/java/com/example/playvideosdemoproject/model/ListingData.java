package com.example.playvideosdemoproject.model;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public class ListingData {
    String status,message;

    Data data=new Data();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
