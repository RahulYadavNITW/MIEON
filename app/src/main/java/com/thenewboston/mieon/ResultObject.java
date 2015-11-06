package com.thenewboston.mieon;

/**
 * Created by rahul on 05/11/15.
 */
public class ResultObject {
    String name;
    String address;
    String ratings;
    boolean storeavailable;
    boolean homeavaialable;

    public ResultObject( String name,String address, String ratings, boolean storeavailable, boolean homeavaialable) {
        this.address = address;
        this.homeavaialable = homeavaialable;
        this.name = name;
        this.ratings = ratings;
        this.storeavailable = storeavailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isHomeavaialable() {
        return homeavaialable;
    }

    public void setHomeavaialable(boolean homeavaialable) {
        this.homeavaialable = homeavaialable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public boolean isStoreavailable() {
        return storeavailable;
    }

    public void setStoreavailable(boolean storeavailable) {
        this.storeavailable = storeavailable;
    }
}
