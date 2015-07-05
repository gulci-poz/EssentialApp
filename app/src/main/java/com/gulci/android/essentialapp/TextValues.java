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
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;


public class TextValues extends AppCompatActivity {

    public static final String LOG_TAG = "TextValues Activity";

    private ArrayList<String> imagesToCycle;
    private int imagesIndex;
    private int res;
    private String imageName;
    private ImageView iv;

    private void imagesCycleUp() {
        imagesIndex = (imagesIndex + 1) % imagesToCycle.size();
    }

    private void switchImage() {
        res = getResources().getIdentifier(imagesToCycle.get(imagesIndex), "drawable", getPackageName());
        imagesCycleUp();
        iv.setImageResource(res);
    }

    private void loadAsset() {
        imageName = imagesToCycle.get(imagesIndex) + ".png";
        imagesCycleUp();

        try {
            InputStream stream = getAssets().open(imageName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            iv.setImageDrawable(drawable);
        }
        catch(Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_values);

        imagesToCycle = new ArrayList<>();
        imagesIndex = 0;
        res = 0;
        imageName = new String();
        iv = (ImageView) findViewById(R.id.raCourse);

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

        //zamiast wpisu w manifeście
        //android:parentActivityName=".RouxActivity"
        //+ obsługa kliknięcia w onOptionsItemSelected
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_text_values, menu);

        MenuItem item = menu.add(Menu.NONE, Menu.NONE, 102, "Item");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(TextValues.this, "You chose an item", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnSwitchImageOnClickHandler(View view) {
        switchImage();
    }

    public void btnLoadAssetOnClickHandler(View view) {
        loadAsset();
    }

    public void actionResourceClickHandler(MenuItem item) {
        switchImage();
    }

    public void actionAssetClickHandler(MenuItem item) {
        loadAsset();
    }
}
