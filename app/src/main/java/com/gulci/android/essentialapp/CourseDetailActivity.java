package com.gulci.android.essentialapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class CourseDetailActivity extends AppCompatActivity {

    public static final String RESULT_MESSAGE = "resultMessage";
    protected String courseTitle;
    protected String courseDesc;
    protected int courseImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        courseTitle = getIntent().getStringExtra(DataListActivity.COURSE_TITLE);
        TextView tvCourseTitle = (TextView) findViewById(R.id.tvCourseTitle);
        tvCourseTitle.setText(courseTitle);

        courseDesc = getIntent().getStringExtra(DataListActivity.COURSE_DESC);
        TextView tvCourseDesc = (TextView) findViewById(R.id.tvCourseDesc);
        tvCourseDesc.setText(courseDesc);

        courseImg = getIntent().getIntExtra(DataListActivity.COURSE_IMG, 0);
        ImageView ivCourseImg = (ImageView) findViewById(R.id.ivCourseImage);
        ivCourseImg.setImageResource(courseImg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_detail, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void btnCourseRegisterHandler(View view) {

        getIntent().putExtra(RESULT_MESSAGE, "You're registered for " + courseTitle);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
