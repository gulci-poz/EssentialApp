package com.gulci.android.essentialapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class RouxActivity extends AppCompatActivity {

    public static final String COURSE_TITLE = "courseTitle";
    public static final int DETAIL_REQUEST_CODE = 1001;
    public static final String RESULT_MESSAGE = "resultMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roux);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_roux, menu);
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

    public void btnOnClickGotoDetailsHandler(View view) {

        Intent detailIntent = new Intent(this, TextValues.class);
        startActivity(detailIntent);
    }

    public void btnOnClickGotoCourseHandler(View view) {

        Intent courseIntent = new Intent(this, CourseActivity.class);

        Course androidAppCourse = new Course();
        //żeby przekazać skomplikowany obiekt, trzeba mieć implementację Parcelable
        courseIntent.putExtra(COURSE_TITLE, androidAppCourse.getTitle());

        startActivityForResult(courseIntent, DETAIL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == DETAIL_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String msg = data.getStringExtra(RESULT_MESSAGE);
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnOnClickGotoWebsiteHandler(View view) {

        Uri webPage = Uri.parse("http://rouxacademy.com/");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
        startActivity(webIntent);
    }
}
