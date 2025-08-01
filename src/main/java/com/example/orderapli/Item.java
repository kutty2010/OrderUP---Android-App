package com.example.orderapli;

public class Item {
    private final String name;
    private final String price;
    private final int image;
    private String offers;
    private final String desc;
    private final float rating;




    public Item(String name, String price, int image, String desc, String offers, float rating) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.desc = desc;
        this.offers = offers;
        this.rating = rating;
    }

    // Getters
    public String getName() { return name; }
    public String getPrice() { return price; }
    public int getImage() { return image; }
    public String getDesc() {
        return desc;
    }
    public String getOffers() {
        return offers;
    }
    public float getRating() {
        return rating;
    }

}