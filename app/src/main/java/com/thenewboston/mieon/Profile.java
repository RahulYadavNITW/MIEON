package com.thenewboston.mieon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;



public class Profile extends AppCompatActivity {

    private List<Review> reviews;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ActionBar actionBar;
    private Toolbar toolbar;
    private String[] myDataset={"RAHUL","RAHUL","RAHUL"};
    ImageView favoriteselected, favoritenotselected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        favoriteselected=(ImageView) findViewById(R.id.Favorite);
        favoritenotselected=(ImageView)findViewById(R.id.notFavorite);

        favoritenotselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoritenotselected.setVisibility(View.INVISIBLE);
                favoriteselected.setVisibility(View.VISIBLE);
            }
        });
        favoriteselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favoriteselected.setVisibility(View.INVISIBLE);
                favoritenotselected.setVisibility(View.VISIBLE);
            }
        });


        toolbar = (Toolbar)findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        initializeData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_reviewsListRow);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(llm);
        ReviewsAdapter adapter = new ReviewsAdapter(reviews);
        mRecyclerView.setAdapter(adapter);

//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/opensans.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );



    }

    private void initializeData()
    {
        Toast.makeText(getApplicationContext(), "ENTERED DATA FUNCTION", Toast.LENGTH_LONG);
        reviews = new ArrayList<>();
        reviews.add(new Review("Samantha Smith","11TH AUG 2015",3,"SHE IS THE MOST AWESOME HAIR STYLIST EVER IN THIS WORLD.. SHE IS VERY ECONOMICAL AND HIGHLY SKILLFULL AND TALENTED"));
        reviews.add(new Review("ERICA JONES","02ND MAY 2015",4,"SHE IS THE BEST.. BLAH BLAH BLAH...SHE IS THE MOST AWESOME HAIR STYLIST EVER IN THIS WORLD.. SHE IS VERY ECONOMICAL.. "));
        reviews.add(new Review("ERICA JONES","02ND MAY 2015",4,"SHE IS THE BEST.. BLAH BLAH BLAH...SHE IS THE MOST AWESOME HAIR STYLIST EVER IN THIS WORLD.. SHE IS VERY ECONOMICAL.. "));

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_dummy2, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setVisible(false);
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent MainActivityIntent = new Intent(Profile.this, ENTER.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }
}


