package com.example.playvideosdemoproject.backend;

import com.example.playvideosdemoproject.model.ListingData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public interface ApiInterface {

    @POST("v1.0/app_getVideosDetails/")
    Call<ListingData> videoListing();

    @FormUrlEncoded
    @POST("v1.0/app_getVideoDetailById")
    Call<ListingData> videoDetail(@Field("video_id") String video_id);
}
