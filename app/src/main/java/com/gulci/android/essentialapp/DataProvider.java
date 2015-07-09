package com.gulci.android.essentialapp;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<Course> data = new ArrayList<>();

    public static List<Course> getData() {

        return data;
    }

    // statyczna inicjalizacja, uruchamia się po wywołaniu getData()
    static {

        data.add(new Course(10101, "App 10101", "Creating 10101 App", 5));
        data.add(new Course(10102, "App 10102", "Creating 10102 App", 5));
        data.add(new Course(10103, "App 10103", "Creating 10103 App", 5));
        data.add(new Course(10104, "App 10104", "Creating 10104 App", 5));
        data.add(new Course(20101, "App 20101", "Creating 20101 App", 5));
        data.add(new Course(20102, "App 20102", "Creating 20102 App", 5));
        data.add(new Course(20103, "App 20103", "Creating 20103 App", 5));
    }
}
