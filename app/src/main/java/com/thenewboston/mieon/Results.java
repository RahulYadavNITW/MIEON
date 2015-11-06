package com.thenewboston.mieon;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Results extends AppCompatActivity {
    ActionBar actionBar;
    private Toolbar toolbar;
    TextView toolbarTitle;
    private RecyclerView mRecyclerView;
    private List<ResultObject> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toolbarTitle = (TextView)findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("RESULTS");
        actionBar = getSupportActionBar();
        actionBar.setTitle("RESULTS");
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        initializeData();
        Log.d("res", " " + results);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView_resultsListRow);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(llm);
        ResultsAdapter adapter = new ResultsAdapter(results);
        mRecyclerView.setAdapter(adapter);

    }

    private void initializeData()
    {
        Toast.makeText(getApplicationContext(),"ENTERED DATA FUNCTION",Toast.LENGTH_LONG);
        results = new ArrayList<>();
        results.add(new ResultObject("Samantha Smith","#124, WEST AVENUE, NEW YORK","3",true,true));
        results.add(new ResultObject("Emma Watson","#124, WEST AVENUE, NEW YORK","4",true,false));
        results.add(new ResultObject("Deepika Padukone","#124, WEST AVENUE, NEW YORK","3.5",false,true));
        results.add(new ResultObject("Shilpa Shetty","#124, WEST AVENUE, NEW YORK","2",false,true));
        results.add(new ResultObject("Aishwarya Rai","#124, WEST AVENUE, NEW YORK","4",true,true));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
        Intent MainActivityIntent = new Intent(Results.this, ENTER.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }

}
