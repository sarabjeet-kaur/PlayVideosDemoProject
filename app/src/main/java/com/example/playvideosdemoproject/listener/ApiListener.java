package com.example.playvideosdemoproject.listener;

import com.example.playvideosdemoproject.model.Data;

import java.util.ArrayList;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public interface ApiListener {
    public void onSuccess(String status , ArrayList<Data> data);
    public void onError(String error_message);
}