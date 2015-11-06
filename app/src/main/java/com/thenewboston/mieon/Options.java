package com.thenewboston.mieon;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.apptik.widget.MultiSlider;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Options extends AppCompatActivity {

    ActionBar actionBar;
    private Toolbar toolbar;
    ImageView home_selected, home_deselected,shop_selected,shop_deselcted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("OPTIONS");
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/opensans.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );

        final TextView minTime = (TextView) findViewById(R.id.minTime);
        final TextView maxTime = (TextView) findViewById(R.id.maxTime);
        MultiSlider multiSlider = (MultiSlider)findViewById(R.id.double_range_slider);
        minTime.setText(String.valueOf(multiSlider.getThumb(0).getValue()));
        maxTime.setText(String.valueOf(multiSlider.getThumb(1).getValue()));

        multiSlider.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener() {
            @Override
            public void onValueChanged(MultiSlider multiSlider, MultiSlider.Thumb thumb, int thumbIndex, int value) {
                if (thumbIndex == 0) {
                    minTime.setText(String.valueOf(value));
                } else {
                    maxTime.setText(String.valueOf(value));
                }
            }
        });

        home_selected=(ImageView)findViewById(R.id.home_selected);
        home_deselected=(ImageView)findViewById(R.id.home_deselected);
        shop_selected=(ImageView)findViewById(R.id.store_selected);
        shop_deselcted=(ImageView)findViewById(R.id.store_deselected);

        home_deselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_deselcted.setVisibility(View.VISIBLE);
                shop_selected.setVisibility(View.INVISIBLE);
                home_selected.setVisibility(View.VISIBLE);
                home_deselected.setVisibility(View.INVISIBLE);
            }
        });
        home_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_deselected.setVisibility(View.VISIBLE);
                home_selected.setVisibility(View.INVISIBLE);
            }
        });
        shop_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_deselcted.setVisibility(View.VISIBLE);
                shop_selected.setVisibility(View.INVISIBLE);
            }
        });
        shop_deselcted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shop_selected.setVisibility(View.VISIBLE);
                shop_deselcted.setVisibility(View.INVISIBLE);
                home_selected.setVisibility(View.INVISIBLE);
                home_deselected.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
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
        Intent MainActivityIntent = new Intent(Options.this, ENTER.class);
        startActivity(MainActivityIntent);
        super.onBackPressed();
    }
}
