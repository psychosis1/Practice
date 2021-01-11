package org.company.data.entity;

public class Service {
    private int id;
    private String title;
    private double cost;
    private int durationInSeconds;
    private String description;
    private double discount;
    private String mainImagePath;

    public Service(String title, double cost, int durationInSeconds, String description, double discount, String mainImagePath) {
        this.title = title;
        this.cost = cost;
        this.durationInSeconds = durationInSeconds;
        this.description = description;
        this.discount = discount;
        this.mainImagePath = mainImagePath;
    }

    public Service(int id, String title, double cost, int durationInSeconds, String description, double discount, String mainImagePath) {
        this(title,cost,durationInSeconds,description,discount,mainImagePath);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(String mainImagePath) {
        this.mainImagePath = mainImagePath;
    }
}
