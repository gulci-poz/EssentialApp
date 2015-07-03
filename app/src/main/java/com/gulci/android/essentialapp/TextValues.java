package com.gulci.android.essentialapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;


public class TextValues extends AppCompatActivity {

    public static final String LOG_TAG = "TextValues Activity";

    private ArrayList<String> imagesToCycle = new ArrayList<>();
    private int imagesIndex = 0;
    private ImageView iv = null;

    private void imagesCycleUp() {
        imagesIndex = (imagesIndex + 1) % imagesToCycle.size();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_values);

        imagesToCycle.add("image_10101");
        imagesToCycle.add("image_10102");
        imagesToCycle.add("image_10103");
        imagesToCycle.add("image_10104");
        imagesToCycle.add("image_20101");
        imagesToCycle.add("image_20102");
        imagesToCycle.add("image_20103");
        imagesToCycle.add("image_30101");
        imagesToCycle.add("image_30102");
        imagesToCycle.add("image_30103");
        imagesToCycle.add("image_30104");
        imagesToCycle.add("image_40101");
        imagesToCycle.add("image_40102");
        imagesToCycle.add("image_50101");
        imagesToCycle.add("image_50102");
        imagesToCycle.add("image_60101");
        imagesToCycle.add("image_60102");
        imagesToCycle.add("image_60103");
        imagesIndex = 1;

        TextView tvLong = (TextView) findViewById(R.id.longText);

        StringBuffer sb = new StringBuffer();
        sb.append(getString(R.string.lorem_ipsum));
        sb.append(getString(R.string.lorem_ipsum));
        sb.append(getString(R.string.lorem_ipsum));
        sb.append(getString(R.string.lorem_ipsum));

        tvLong.setText(sb.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_text_values, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*
        if(item.getItemId() == R.id.action_switch_image) {
            Log.d(LOG_TAG, "switch image option selected");
        }
        */

        return super.onOptionsItemSelected(item);
    }

    public void btnSwitchImageOnClickHandler(View view) {

        int res = getResources().getIdentifier(imagesToCycle.get(imagesIndex), "drawable", getPackageName());
        imagesCycleUp();
        iv = (ImageView) findViewById(R.id.raCourse);
        iv.setImageResource(res);
    }

    public void btnLoadAssetOnClickHandler(View view) {

        String imageName = new String(imagesToCycle.get(imagesIndex) + ".png");
        imagesCycleUp();

        try {
            InputStream stream = getAssets().open(imageName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv = (ImageView) findViewById(R.id.raCourse);
            iv.setImageDrawable(drawable);
        }
        catch(Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    public void actionResourceClickHandler(MenuItem item) {
        int res = getResources().getIdentifier(imagesToCycle.get(imagesIndex), "drawable", getPackageName());
        imagesCycleUp();
        iv = (ImageView) findViewById(R.id.raCourse);
        iv.setImageResource(res);
    }

    public void actionAssetClickHandler(MenuItem item) {
        String imageName = new String(imagesToCycle.get(imagesIndex) + ".png");
        imagesCycleUp();

        try {
            InputStream stream = getAssets().open(imageName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv = (ImageView) findViewById(R.id.raCourse);
            iv.setImageDrawable(drawable);
        }
        catch(Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }
}
