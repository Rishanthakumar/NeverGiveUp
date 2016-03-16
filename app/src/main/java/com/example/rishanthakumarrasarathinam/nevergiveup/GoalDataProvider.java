package com.example.rishanthakumarrasarathinam.nevergiveup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishanthakumarrasarathinam on 3/11/16.
 */
public class GoalDataProvider {

    private static List<Goal> data = new ArrayList<>();

    public static List<Goal> getData() {
        return data;
    }

    static {

        data.add(new Goal(10101, "Programming", "n/a", 3));
        data.add(new Goal(10102, "Fitness", "n/a", 3));
        data.add(new Goal(10103, "Quit Smoking", "n/a", 3));
        data.add(new Goal(10104, "Dieting", "n/a", 3));
        data.add(new Goal(10105, "Managing Addiction", "n/a", 3));
        data.add(new Goal(10106, "Training For Big Event", "n/a", 3));


    }

    }
