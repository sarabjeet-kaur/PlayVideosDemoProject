package com.example.playvideosdemoproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.playvideosdemoproject.adapter.VideoListingAdapter;
import com.example.playvideosdemoproject.listener.ApiListener;
import com.example.playvideosdemoproject.model.Data;
import com.example.playvideosdemoproject.permission.CheckNetwork;
import com.example.playvideosdemoproject.request.VideoListing;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ApiListener {

    private RecyclerView rv_video_listing;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        if (CheckNetwork.isNetworkAvailable(MainActivity.this))
            videoListing();
        else
            CheckNetwork.showAlert(getString(R.string.connection_failure), MainActivity.this);

    }

    public void videoListing() {
        VideoListing videoListing = new VideoListing();
        videoListing.videoListing(this);
    }

    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rv_video_listing = (RecyclerView) findViewById(R.id.rv_video_listing);

    }

    @Override
    public void onSuccess(String status, ArrayList<Data> data) {
        setAdapter(data);

    }

    @Override
    public void onError(String error_message) {
        Log.e("onError", error_message);
    }

    private void setAdapter(ArrayList<Data> data) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_video_listing.setLayoutManager(layoutManager);
        VideoListingAdapter adapter = new VideoListingAdapter(data, MainActivity.this);
        rv_video_listing.setAdapter(adapter);
    }
}
