package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{
    private Context context;
    private List<News> newsList;
    private NewsAdapter.OnColumnClickListener listener;

    public NewsAdapter(Context context, List<News> newsList, NewsAdapter.OnColumnClickListener clickListener) {
        this.context = context;
        this.newsList = newsList;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_column,parent,false);
        return new NewsAdapter.NewsViewHolder(itemView, listener );
    }

    public interface OnColumnClickListener {
        void onItemClick2 (int position);
    }
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        holder.newsImageView.setImageResource(newsList.get(position).getImage());
        holder.newsPublisherTextView.setText(newsList.get(position).getPublisher());
        holder.newsTitleTextView.setText(newsList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView newsImageView ;
        public TextView newsPublisherTextView,newsTitleTextView;
        public NewsAdapter.OnColumnClickListener onColumnClickListener;
        public NewsViewHolder(@NonNull View itemView, NewsAdapter.OnColumnClickListener onColumnClickListener) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.newsImageView);
            newsPublisherTextView = itemView.findViewById(R.id.publisherTextView);
            newsTitleTextView = itemView.findViewById(R.id.titleNewsTextView);
            this.onColumnClickListener = onColumnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onColumnClickListener.onItemClick2(getAdapterPosition());
        }
    }
}
