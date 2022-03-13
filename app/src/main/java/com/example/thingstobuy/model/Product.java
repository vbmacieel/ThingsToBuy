package com.example.thingstobuy.model;

public class Product {
    private long id;
    private String name;
    private String siteUrl;
    private String imagePath;
    private double value;

    public Product(long id, String name, String siteUrl, String imagePath, double value) {
        this.id = id;
        this.name = name;
        this.siteUrl = siteUrl;
        this.imagePath = imagePath;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
