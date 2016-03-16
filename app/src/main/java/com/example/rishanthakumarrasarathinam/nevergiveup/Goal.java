package com.example.rishanthakumarrasarathinam.nevergiveup;

/**
 * Created by rishanthakumarrasarathinam on 3/11/16.
 */
public class Goal {

    private int goalNumber;
    private String title;
    private String description;
    private int duration;

    public Goal(int goalNumber, String title, String description, int duration) {
        this.goalNumber = goalNumber;
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public int getGoalNumber() {
        return goalNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return title;
    }
}
