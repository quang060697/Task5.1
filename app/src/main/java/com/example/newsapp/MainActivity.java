package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StoryAdapter.OnColumnClickListener,NewsAdapter.OnColumnClickListener{
    Integer[] storyImageList = {R.drawable.waiting, R.drawable.teaching,R.drawable.smoke};
    Integer[] newsImageList = {R.drawable.dog, R.drawable.house,R.drawable.mcdonald,R.drawable.colse};

    String title1 = "Masking while traveling protects you even if others don't wear them, experts say ";
    String detail1 = "Masks are no longer required on most airplanes, subway trains or buses, after a Florida judge on Monday struck down the federal mask mandate for travel.\n" +
            "\n" +
            "The decision came amid a rise in Covid cases in the U.S., mostly due to the BA.2 omicron subvariant. New daily cases are up 42 percent in the last two weeks, according to NBC News' tally, though that number is almost certainly an undercount given the common use of at-home tests.";
    String title2 = "Some states raise teacher pay amid pandemic shortage, but can they retain the educators?";
    String detail2 = "“We can’t afford rent or our mortgage and the price of gasoline and food,” a middle school art teacher in Santa Fe, New Mexico, said."+ "\n"
            +"Jamie Torres spent the first three years of her teaching career “practically being homeless.” Her starting salary of $38,000 in 2018 wasn’t enough to afford rent in the neighborhoods near where she taught in Sante Fe, New Mexico, so she bunked with family members for months at a time or stayed with friends.";
    String title3 = "Nebraska wildfires kill ex-fire chief, hurt 15 firefighters";
    String detail3 = "Blazes have been reported in 14 counties around the state, authorities said."+"\n" +
            "CAMBRIDGE, Neb. — Wind-driven wildfires sweeping through parts of Nebraska killed a retired fire chief and injured at least 15 firefighters, authorities said Sunday.";

    String newsDetail1 = "New South Wales transport workers have a new furry employee who is helping support their mental health.\n" +
            "Bentley, an 18-month-old pure-bred miniature poodle, is the first mental health assistance dog to work on the state's railway lines.\n" +
            "The little pup is a fully accredited mental health assistance dog and is currently working on the Blue Mountains train line to support train staff and customers.";
    String newsDetail2 = "Melbourne’s pandemic property boom has come to an end, as new figures show house prices fell for the first time since the June quarter of 2020 amid jitters over rising interest rates.\n" +
            "\n" +
            "Melbourne house prices fell 0.7 per cent to a median $1.092 million in the March quarter, the latest Domain House Price Report, released on Thursday, shows. Unit prices shed 2.2 per cent to a median of $578,775 over the quarter, their steepest fall since 2017.";
    String newsDetail3 = "A US family who were renovating their home have unearthed a bag of McDonald’s french fries that had apparently been sitting inside a wall for more than 60 years.\n" +
            "\n" +
            "Rob and Grace Jones were fixing up their kitchen and bathroom on April 16 in Crystal Lake, which is about 75km northwest of downtown Chicago, when they made the fast-food discovery.";
    String newsDetail4 = "Coles has warned shoppers to expect higher prices and \"inflationary pressures\" at its supermarket for at least another year, while the Australian share market has rebounded after a three-day losing streak.\n" +
            "\n" +
            "The ASX 200 index closed 1.3 per cent higher, at 7,357 points.";

    String newsTitle1="Meet Bentley, the puppy supporting NSW transport staff and customers' mental health";
    String newsTitle2="Buyers have choice: Melbourne house prices fall for the first time since 2020";
    String newsTitle3="Family finds preserved McDonald’s french fries from over 60 years ago";
    String newsTitle4="Coles warns grocery prices and inflation will rise through to 2023, Australian shares rebound";


    String[] publisherList = {"9NEWS","7NEWS","ABC NEWS","THE AGE"};
    String[] newsTitleList = {newsTitle1,newsTitle2,newsTitle3,newsTitle4};

    String[] titleList = {title1,title2,title3};
    String[] detailList = {detail1,detail2,detail3};

    String[] newsDetailList = {newsDetail1,newsDetail2,newsDetail3,newsDetail4};

    List<Story> storyList = new ArrayList<>();
    List<News> newsList = new ArrayList<>();

    RecyclerView storyRecycleView;
    RecyclerView newsRecycleView;
    RecyclerView rNewsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i= 0 ; i< storyImageList.length; i++)
        {

            Story story = new Story(i, storyImageList[i]);
            storyList.add(story);

        }

        storyRecycleView = findViewById(R.id.storyRecyleView);
        StoryAdapter storyAdapter = new StoryAdapter(MainActivity.this,storyList,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        storyRecycleView.setLayoutManager(layoutManager);
        storyRecycleView.setAdapter(storyAdapter);

        for (int i= 0 ; i< newsImageList.length; i++)
        {

            News news2 = new News(i, newsImageList[i],publisherList[i],newsTitleList[i]);
            newsList.add(news2);

        }

        newsRecycleView = findViewById(R.id.newsRecycleView);
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this,newsList,this);

        newsRecycleView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        newsRecycleView.setAdapter(newsAdapter);


    }



    @Override
    public void onItemClick(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        NewsFragment fragment1 = (NewsFragment)getSupportFragmentManager().
                findFragmentById(R.id.fragmentContainerView);
        findViewById(R.id.fragmentContainerView).setVisibility(View.VISIBLE);
        fragment1.updateContent(storyImageList[position],titleList[position],detailList[position],this,position);



        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment1 )
                            .commit();
    }
    @Override
    public void onBackPressed() {
        findViewById(R.id.fragmentContainerView).setVisibility(View.INVISIBLE);
        return;
    }

    @Override
    public void onItemClick2(int position) {
        FragmentManager fragmentManager2 = getSupportFragmentManager();
        NewsFragment fragment2 = (NewsFragment)getSupportFragmentManager().
                findFragmentById(R.id.fragmentContainerView);
        findViewById(R.id.fragmentContainerView).setVisibility(View.VISIBLE);
        fragment2.updateContent(newsImageList[position],newsTitleList[position],newsDetailList[position],this,position);



        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment2 )
                .commit();
    }
}

