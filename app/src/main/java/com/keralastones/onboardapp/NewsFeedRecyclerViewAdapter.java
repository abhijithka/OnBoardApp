package com.keralastones.onboardapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NewsFeedRecyclerViewAdapter extends RecyclerView.Adapter<NewsFeedRecyclerViewAdapter.NewsFeedVH>  {

    Context context;
    List<NewsFeedObject> newsFeedObjects;

    NewsFeedRecyclerViewAdapter(Context context, List<NewsFeedObject> newsFeedObjects) {
        this.context = context;
        this.newsFeedObjects = newsFeedObjects;
    }

    @NonNull
    @Override
    public NewsFeedVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.feed_item, parent, false);
        return new NewsFeedVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedVH holder, int position) {
        holder.newsTitle.setText(newsFeedObjects.get(position).getTitle());
        holder.newsTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return newsFeedObjects.size();
    }

    class NewsFeedVH extends RecyclerView.ViewHolder {
        TextView newsTitle;

        NewsFeedVH(View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.news_title);
        }
    }
}
