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
    public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.RelatedNewsViewHolder>{
    private Context context;
    private List<News> newsList;
    private RelatedNewsAdapter.OnColumnClickListener listener;

    public RelatedNewsAdapter(Context context, List<News> newsList, RelatedNewsAdapter.OnColumnClickListener clickListener) {
        this.context = context;
        this.newsList = newsList;
        this.listener = clickListener;
        }

    @NonNull
    @Override
    public RelatedNewsAdapter.RelatedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_news_row,parent,false);
        return new RelatedNewsAdapter.RelatedNewsViewHolder(itemView, listener );
        }

    public interface OnColumnClickListener {
        void onItemClick3 (int position);
    }
    @Override
    public void onBindViewHolder(@NonNull RelatedNewsAdapter.RelatedNewsViewHolder holder, int position) {
        holder.rNewsImageView.setImageResource(newsList.get(position).getImage());
        holder.rNewsPublisherTextView.setText(newsList.get(position).getPublisher());
        holder.rNewsTitleTextView.setText(newsList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class RelatedNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView rNewsImageView ;
    public TextView rNewsPublisherTextView,rNewsTitleTextView;
    public RelatedNewsAdapter.OnColumnClickListener onColumnClickListener;
    public RelatedNewsViewHolder(@NonNull View itemView, RelatedNewsAdapter.OnColumnClickListener onColumnClickListener) {
        super(itemView);
        rNewsImageView = itemView.findViewById(R.id.rNewsImageView);
        rNewsPublisherTextView = itemView.findViewById(R.id.rNewsPublisherTextView);
        rNewsTitleTextView = itemView.findViewById(R.id.rNewsDetailTextView);
        this.onColumnClickListener = onColumnClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onColumnClickListener.onItemClick3(getAdapterPosition());
    }
}

}
