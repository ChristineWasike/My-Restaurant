package com.example.wasike.myrestaurants;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @Bind(R.id.locationTextView)
    TextView mLocationTextView;
    @Bind(R.id.listView)
    ListView mListView;
    private String[] restaurants = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House",
            "Viking Soul Food", "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell",
            "Me Kha Noodle Bar", "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar",
            "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };

    private String[] cuisines = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs",
            "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups",
            "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };
    public static  final String TAG = RestaurantsActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);


        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        //must match constructor!
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
                Log.v("TAG", "In the onItemClickListener!");
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near: " + location);
        Log.d("TAG", "In the onCreate method!");


    }
}
