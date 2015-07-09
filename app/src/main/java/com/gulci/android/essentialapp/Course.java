package com.gulci.android.essentialapp;

public class Course {

    private int courseNumber;
    private String title;
    private String description;
    private double credits;

    public Course(int courseNumber, String title, String description, double credits) {
        this.courseNumber = courseNumber;
        this.title = title;
        this.description = description;
        this.credits = credits;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {

        return title;
    }
}
