package com.example.wasike.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wasike on 11/09/17.
 */

@Parcel
public class Restaurant {
    private String name;
    private String phone;
    private String website;
    private double rating;
    private String imageUrl;
    private List<String> address = new ArrayList<>();
    private double latitude;
    private double longitude;
    private List<String> categories = new ArrayList<>();

    public Restaurant() {}


    public Restaurant(String name, String phone, String website,
                      double rating, String imageUrl, ArrayList<String> address) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.address = address;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.mCategories = categories;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return  website;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0,
                imageUrl.length() -5).concat("o.jpg");
        return largeImageUrl;
    }

    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<String> getCategories() {
        return categories;
    }
}
