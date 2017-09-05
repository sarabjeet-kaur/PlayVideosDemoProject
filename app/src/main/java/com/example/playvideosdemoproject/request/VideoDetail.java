package com.example.playvideosdemoproject.request;

import android.util.Log;

import com.example.playvideosdemoproject.backend.ConnectionModule;
import com.example.playvideosdemoproject.listener.VideoDetailListener;
import com.example.playvideosdemoproject.model.ListingData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public class VideoDetail {

    public void videoDetailById(final String video_id, final VideoDetailListener listener){
        ConnectionModule.getApiService().videoDetail(video_id).enqueue(new Callback<ListingData>() {
            @Override
            public void onResponse(Call<ListingData> call, Response<ListingData> response) {
                if (response != null){
                    Log.e("response",response+"");

                    if (response.body() != null && response.body().getData()!=null) {

                        listener.onSuccess(response.body().getStatus()+"");

                    }
                    else{
                        listener.onError(response.body().getStatus());
                    }
                }
                else{
                    Log.e("null","received");
                }
            }

            @Override
            public void onFailure(Call<ListingData> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
