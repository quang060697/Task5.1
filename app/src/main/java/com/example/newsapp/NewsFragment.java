package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    String newsDetail1 = "“We can’t afford rent or our mortgage and the price of gasoline and food,” a middle school art teacher in Santa Fe, New Mexico, said."+ "\n"
            +"Jamie Torres spent the first three years of her teaching career “practically being homeless.” Her starting salary of $38,000 in 2018 wasn’t enough to afford rent in the neighborhoods near where she taught in Sante Fe, New Mexico, so she bunked with family members for months at a time or stayed with friends.";

    String newsDetail2 = "Blazes have been reported in 14 counties around the state, authorities said."+"\n" +
            "CAMBRIDGE, Neb. — Wind-driven wildfires sweeping through parts of Nebraska killed a retired fire chief and injured at least 15 firefighters, authorities said Sunday.";

    String newsDetail3 = "A US family who were renovating their home have unearthed a bag of McDonald’s french fries that had apparently been sitting inside a wall for more than 60 years.\n" +
            "\n" +
            "Rob and Grace Jones were fixing up their kitchen and bathroom on April 16 in Crystal Lake, which is about 75km northwest of downtown Chicago, when they made the fast-food discovery.";
    String newsDetail4 = "Melbourne’s pandemic property boom has come to an end, as new figures show house prices fell for the first time since the June quarter of 2020 amid jitters over rising interest rates.\n" +
            "\n" +
            "Melbourne house prices fell 0.7 per cent to a median $1.092 million in the March quarter, the latest Domain House Price Report, released on Thursday, shows. Unit prices shed 2.2 per cent to a median of $578,775 over the quarter, their steepest fall since 2017.";
    String[] newsDetailList = {newsDetail1,newsDetail2,newsDetail3,newsDetail4};

    Context context;
    Integer position;
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
         this.context = context;
         this.position = position;
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
        Random rn = new Random();

        int a = rn.nextInt(4) ;
        FragmentManager fragmentManager2 = getParentFragmentManager();
        NewsFragment fragment3 = (NewsFragment)getParentFragmentManager().
                findFragmentById(R.id.fragmentContainerView);
        fragment3.updateContent(newsImageList[this.position],newsTitleList[this.position],newsDetailList[this.position],this.context, a);
        Collections.reverse(Arrays.asList(newsList));



        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment3 )
                .commit();
    }

}