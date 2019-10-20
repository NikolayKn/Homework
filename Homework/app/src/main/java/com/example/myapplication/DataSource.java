package com.example.myapplication;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;


public class DataSource {

    private static List<MyData> mData;
    private static DataSource sInstance;

    public synchronized static DataSource getInstance() {
        if (sInstance == null) {
            sInstance = new DataSource();
        }
        return sInstance;
    }


    private static int[] colors = new int[]{
            Color.RED,
            Color.BLUE
    };

    public DataSource() {
        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String number = Integer.toString(i + 1);
            int color = colors[i % 2];
            mData.add(new MyData(number, color));
        }
    }

    public static void addnext() {
        int number = mData.size();
        int color = colors[number % 2];
        mData.add(new MyData(Integer.toString(number + 1), color));


    }


    public static class MyData {
        public MyData(String number, int color) {
            mnumber = number;
            mcolor = color;
        }

        String mnumber;
        int mcolor;
    }


    public List<MyData> getData() {
        return mData;

    }


}