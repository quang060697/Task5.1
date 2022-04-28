package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment implements RelatedNewsAdapter.OnColumnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView img;
    private TextView fragmentTitleTextView,fragmentBodyTextView;
    Integer[] newsImageList = {R.drawable.teaching, R.drawable.smoke,R.drawable.mcdonald,R.drawable.house};
    String title1 = "Some states raise teacher pay amid pandemic shortage, but can they retain the educators?";
    String title2 = "Nebraska wildfires kill ex-fire chief, hurt 15 firefighters";
    String title3 = "Family finds preserved McDonald’s french fries from over 60 years ago";
    String title4 = "Buyers have choice: Melbourne house prices fall for the first time since 2020";

    List<News> newsList = new ArrayList<>();
    String[] publisherList = {"9NEWS","7NEWS","ABC NEWS","THE AGE"};
    String[] newsTitleList = {title1,title2,title3,title4};

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
    public void updateContent(int imageID, String title, String body, Context context,Integer position )
    {
         img = getView().findViewById(R.id.imageView);
         img.setImageResource(imageID);
         fragmentTitleTextView = getView().findViewById(R.id.fragmentTitleTextView);
         fragmentTitleTextView.setText(title);
         fragmentBodyTextView = getView().findViewById(R.id.fragmenBodyTextView);
         fragmentBodyTextView.setText(body);

         News news2 = new News(position, newsImageList[position],publisherList[position],newsTitleList[position]);
         newsList.removeAll(newsList);
         newsList.add(news2);

         RecyclerView rNewsRecycleView = getView().findViewById(R.id.rNewsRecyclerView);
         RelatedNewsAdapter rNewsAdapter = new RelatedNewsAdapter(context,newsList,this::onItemClick3);
         RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
         rNewsRecycleView.setLayoutManager(layoutManager2);
         rNewsRecycleView.setAdapter(rNewsAdapter);
    }

    @Override
    public void onItemClick3(int position) {

    }

}