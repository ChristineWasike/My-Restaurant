package com.example.wasike.myrestaurants.services;

import android.util.Log;

import com.example.wasike.myrestaurants.Constants;
import com.example.wasike.myrestaurants.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wasike on 11/09/17.
 */

public class YelpService {
    public static void findRestaurants(String location, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();

        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);

        String url = urlBuilder.build().toString();

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .header("Authorization", Constants.YELP_TOKEN)
                .url(url)
                .build();
        Log.v("Information display", url);

        Call call = client.newCall(request);
        //Just for now will change shortly if necessary
        call.enqueue(callback);

    }

    public ArrayList<Restaurant> processResults(Response response) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yelpJSON = new JSONObject(jsonData);
                JSONArray businessJSON = yelpJSON.getJSONArray("businesses");
                for (int i= 0; i < businessJSON.length(); i ++) {
                    JSONObject restaurantJSON = businessJSON.getJSONObject(i);
                    String name = restaurantJSON.getString("name");
                    String phone = restaurantJSON.optString("display_phone", "Phone not available");
                    String website = restaurantJSON.getString("url");
                    double rating = restaurantJSON.getDouble("rating");
                    String imageUrl = restaurantJSON.getString("image_url");
//                    double latitude = restaurantJSON.getJSONObject("location")
//                            .getJSONObject("coordinate").getDouble("latitude");
//                    double longitude = restaurantJSON.getJSONObject("location")
//                            .getJSONObject("coordinate").getDouble("longitude");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = restaurantJSON.getJSONObject("location")
                            .getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++) {
                        address.add(addressJSON.get(y).toString());
                    }

//                    ArrayList<String> categories = new ArrayList<>();
//                    JSONArray categoriesJSON = restaurantJSON.getJSONArray("categories");

//                    for (int y = 0; y < categoriesJSON.length(); y++) {
//                        categories.add(categoriesJSON.getJSONArray(y).get(0).toString());
//                    }
                    Restaurant restaurant = new Restaurant(name, phone, website, rating,
                            imageUrl, address);
                    restaurants.add(restaurant);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return restaurants;

        }
    }


