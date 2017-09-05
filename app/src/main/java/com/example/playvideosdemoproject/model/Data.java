package com.example.playvideosdemoproject.model;

import java.util.ArrayList;

/**
 * Created by sarabjjeet on 9/5/17.
 */
// Model class to get Array of data from response
public class Data {

    String id;
    String title;
    String video_path;
    String description;

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(String thumb_image) {
        this.thumb_image = thumb_image;
    }

    String thumb_image;
    ArrayList<Data> videos=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Data> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Data> videos) {
        this.videos = videos;
    }
}
