package com.thenewboston.mieon;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class dummy_profile_details extends AppCompatActivity {

    private ListView listView;
    ActionBar actionBar;
    private Toolbar toolbar;
    private String[] myDataset={"RAHUL","RAHUL","RAHUL"};
    ImageView favoriteselected, favoritenotselected;
//    List<Services> items;
    ArrayList<Services> servicesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_profile_2);
        ArrayList<Services> arrayOfUsers = new ArrayList<Services>();
// Create the adapter to convert the array to views
        ServicesAdapter itemsAdapter = new ServicesAdapter(dummy_profile_details.this,0, arrayOfUsers);


        listView=(ListView)findViewById(R.id.listviewServices);
        listView.setAdapter(itemsAdapter);
        servicesArrayList=new ArrayList<>();

        servicesArrayList.add(new Services("OIL MESSAGE","$32"));
        servicesArrayList.add(new Services("Hair cut", "$100"));
        servicesArrayList.add(new Services("Waxing","$70"));
        servicesArrayList.add(new Services("Steam Bath", "$82"));
        servicesArrayList.add(new Services("NAILS CUTTING", "$24"));
        servicesArrayList.add(new Services("Physiotherapy", "$92"));
        servicesArrayList.add(new Services("Pedicure", "$12"));
        itemsAdapter.addAll(servicesArrayList);


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
        actionBar.setTitle("HAIRSTYLISTS");
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_reviewsListRow);
//        mRecyclerView.setHasFixedSize(true);

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
        Intent MainActivityIntent = new Intent(dummy_profile_details.this, ENTER.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }
}
