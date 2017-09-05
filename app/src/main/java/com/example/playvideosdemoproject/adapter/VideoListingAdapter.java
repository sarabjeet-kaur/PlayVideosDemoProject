package com.example.playvideosdemoproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.playvideosdemoproject.DetailActivity;
import com.example.playvideosdemoproject.R;
import com.example.playvideosdemoproject.model.Data;

import java.util.ArrayList;

/**
 * Created by sarabjjeet on 9/5/17.
 */

public class VideoListingAdapter extends RecyclerView.Adapter<VideoListingAdapter.CustomViewHolder> {
    private ArrayList<Data> data = new ArrayList<>();
    private Context context;


    //CONSTRUCTOR
    public VideoListingAdapter(ArrayList<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public VideoListingAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_video_list, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VideoListingAdapter.CustomViewHolder holder, final int position) {

        holder.title.setText(data.get(position).getTitle());
        Glide.with(context).load(data.get(position).getThumb_image()).skipMemoryCache(true).into(holder.thumb_image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("video_id",data.get(position).getId());
                intent.putExtra("title",data.get(position).getTitle());
                intent.putExtra("video_path",data.get(position).getVideo_path());
                intent.putExtra("description",data.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != data ? data.size() : 0);

    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView thumb_image;
        TextView title;

        public CustomViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.title);
            this.thumb_image = (ImageView) view.findViewById(R.id.thumb_image);


        }
    }
}
