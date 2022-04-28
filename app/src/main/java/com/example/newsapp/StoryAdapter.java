package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private Context context;
    private List<Story> storyList;
    private OnColumnClickListener listener;

    public StoryAdapter(Context context, List<Story> storyList, OnColumnClickListener clickListener) {
        this.context = context;
        this.storyList = storyList;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.story_column,parent,false);
        return new StoryViewHolder(itemView, listener );
    }

    public interface OnColumnClickListener {
        void onItemClick (int position);
    }
    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        holder.storyImageView.setImageResource(storyList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView storyImageView ;
        public OnColumnClickListener onColumnClickListener;
        public StoryViewHolder(@NonNull View itemView, OnColumnClickListener onColumnClickListener) {
            super(itemView);
            storyImageView = itemView.findViewById(R.id.storyImageView);
            this.onColumnClickListener = onColumnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onColumnClickListener.onItemClick(getAdapterPosition());
        }
    }
}
