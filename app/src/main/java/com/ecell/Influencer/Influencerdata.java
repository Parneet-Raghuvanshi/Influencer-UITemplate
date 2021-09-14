package com.ecell.Influencer;

public class Influencerdata {
    private String name;
    private String channel_name;
    private String platform;
    private String genre;
    private String gender;
    private String category;
    private String location;
    private String followers;

    public Influencerdata(String name, String channel_name, String platform, String genre, String gender, String category, String location, String followers) {
        this.name = name;
        this.channel_name = channel_name;
        this.platform = platform;
        this.genre = genre;
        this.gender = gender;
        this.category = category;
        this.location = location;
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }
}
