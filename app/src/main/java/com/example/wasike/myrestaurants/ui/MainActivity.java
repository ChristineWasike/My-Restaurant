package com.example.wasike.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wasike.myrestaurants.Constants;
import com.example.wasike.myrestaurants.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.findRestaurantsButton) public Button mFindRestaurantsButton;
    @Bind(R.id.appNameTextView) public TextView mAppNameTextView;
    @Bind(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface Anonymous = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");
        mAppNameTextView.setTypeface(Anonymous);

        mFindRestaurantsButton.setOnClickListener(this);

        mSavedRestaurantsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mFindRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);

            startActivity(intent);
        }

        if (v == mSavedRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, SavedRestuarantListActivity.class);

            startActivity(intent);
        }

    }
}

