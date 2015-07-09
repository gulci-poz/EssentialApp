package com.gulci.android.essentialapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;


public class DataListActivity extends AppCompatActivity {

    public static final String COURSE_TITLE = "courseTitle";
    public static final String COURSE_DESC = "courseDesc";
    public static final String COURSE_IMG = "courseImg";
    public static final int DETAIL_REQUEST_CODE = 1001;
    public static final String RESULT_MESSAGE = "resultMessage";
    protected List<Course> data;

    private void displayDetail(Course course) {
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(COURSE_TITLE, course.getTitle());
        intent.putExtra(COURSE_DESC, course.getDescription());

        int res = getResources().getIdentifier("image_" + course.getCourseNumber(), "drawable", getPackageName());
        intent.putExtra(COURSE_IMG, res);
        startActivityForResult(intent, DETAIL_REQUEST_CODE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);

        data = DataProvider.getData();

        /*
        ArrayAdapter<Course> courseArrayAdapter =
                new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, data);
        */

        ArrayAdapter<Course> courseArrayAdapter =
                new CourseArrayAdapter(this, 0, data);

        ListView lvCourses = (ListView) findViewById(android.R.id.list);
        lvCourses.setAdapter(courseArrayAdapter);

        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = data.get(position);
                displayDetail(course);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data_list, menu);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == DETAIL_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String msg = data.getStringExtra(RESULT_MESSAGE);
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    class CourseArrayAdapter extends ArrayAdapter<Course> {

        Context context;
        List<Course> objects;

        public CourseArrayAdapter(Context context, int resource, List<Course> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Course course = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.course_item, null);

            TextView tv = (TextView) view.findViewById(R.id.tvTitle);
            tv.setText(course.getTitle());

            ImageView iv = (ImageView) view.findViewById(R.id.imageCourse);
            int res = context.getResources().getIdentifier(
                    "image_" + course.getCourseNumber(), "drawable", context.getPackageName()
            );
            iv.setImageResource(res);

            return view;
        }
    }
}
