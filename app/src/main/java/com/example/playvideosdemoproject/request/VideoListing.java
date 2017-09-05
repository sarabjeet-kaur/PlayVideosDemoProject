package com.example.playvideosdemoproject.request;

import android.util.Log;

import com.example.playvideosdemoproject.backend.ConnectionModule;
import com.example.playvideosdemoproject.listener.ApiListener;
import com.example.playvideosdemoproject.model.Data;
import com.example.playvideosdemoproject.model.ListingData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public class VideoListing {

    ArrayList<Data> data=new ArrayList<>();

    public void videoListing(final ApiListener listener){
        ConnectionModule.getApiService().videoListing().enqueue(new Callback<ListingData>() {
            @Override
            public void onResponse(Call<ListingData> call, Response<ListingData> response) {
                if (response != null){

                    if (response != null && response.body() != null && response.body().getData()!=null) {

                        data=response.body().getData().getVideos();

                        Log.e("data size", data.size()+"");


                        for(int i=0;i<data.size();i++){
                            Log.e("id",data.get(i).getId()+"");
                        }

                        listener.onSuccess(response.body().getStatus()+"",data);
                    }
                    else{
                        listener.onError(response.body().getStatus()+"");
                    }
                }
                else
                    listener.onError("Null received");
            }

            @Override
            public void onFailure(Call<ListingData> call, Throwable t) {
                listener.onError(""+t.getMessage());
            }
        });
    }
}
