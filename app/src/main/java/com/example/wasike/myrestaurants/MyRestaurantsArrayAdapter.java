package com.example.wasike.myrestaurants;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by wasike on 06/09/17.
 */

public class MyRestaurantsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MyRestaurantsArrayAdapter(Context mContext, int resource, String[] mRestaurants, String[] mCuisines) {
        super(mContext, resource); //because I'm inheriting from a class with no default, parameterless constructor.
        this.mContext = mContext;
        this.mRestaurants = mRestaurants;
        this.mCuisines = mCuisines;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];
        return String.format("%s \nServes great: %s", restaurant, cuisine);
    }

    @Override
    public int getCount(){
        return mRestaurants.length; //required by the ListView to know how many items to draw into the UI.
    }
}
