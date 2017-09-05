package com.example.playvideosdemoproject;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playvideosdemoproject.listener.VideoDetailListener;
import com.example.playvideosdemoproject.permission.CheckNetwork;
import com.example.playvideosdemoproject.request.VideoDetail;
import com.halilibo.bettervideoplayer.BetterVideoPlayer;

public class DetailActivity extends AppCompatActivity implements VideoDetailListener {
    private TextView video_title, video_description;
    private BetterVideoPlayer video_View;
    private String title, video_path, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViewById();
        if (CheckNetwork.isNetworkAvailable(DetailActivity.this))
            videoDetailById();
        else
            CheckNetwork.showAlert(getString(R.string.connection_failure), DetailActivity.this);

    }

    @Override
    public void onSuccess(String status) {

        video_title.setText(title);
        video_View.setSource(Uri.parse(video_path));
        video_description.setText(Html.fromHtml(description));
    }

    @Override
    public void onError(String error_message) {
        Toast.makeText(this, error_message, Toast.LENGTH_SHORT).show();
    }

    private void initViewById() {

        video_title = (TextView) findViewById(R.id.video_title);
        video_description = (TextView) findViewById(R.id.video_description);
        video_description.setMovementMethod(new ScrollingMovementMethod());
        video_View = (BetterVideoPlayer) findViewById(R.id.video_View);

    }

    public void videoDetailById() {
        String video_id = getIntent().getStringExtra("video_id");
        title = getIntent().getStringExtra("title");
        video_path = getIntent().getStringExtra("video_path");
        description = getIntent().getStringExtra("description");
        Log.e("title", title);
        Log.e("url", video_path);
        Log.e("desc", description);

        VideoDetail videoDetail = new VideoDetail();
        videoDetail.videoDetailById(video_id, this);
    }
}
