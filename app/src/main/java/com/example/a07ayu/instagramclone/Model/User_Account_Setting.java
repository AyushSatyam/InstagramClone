package com.example.a07ayu.instagramclone.Model;

public class User_Account_Setting {
    private String discription, display_name, profile_photo,username, website;
    private long followers, followings, posts;

    public User_Account_Setting() {

    }

    public User_Account_Setting(String discription, String display_name, String profile_photo, String username, String website, long followers, long followings, long posts) {
        this.discription = discription;
        this.display_name = display_name;
        this.profile_photo = profile_photo;
        this.username = username;
        this.website = website;
        this.followers = followers;
        this.followings = followings;
        this.posts = posts;
    }



    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFollowings() {
        return followings;
    }

    public void setFollowings(long followings) {
        this.followings = followings;
    }

    public long getPosts() {
        return posts;
    }

    public void setPosts(long posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User_Account_Setting{" +
                "discription='" + discription + '\'' +
                ", display_name='" + display_name + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", username='" + username + '\'' +
                ", website='" + website + '\'' +
                ", followers=" + followers +
                ", followings=" + followings +
                ", posts=" + posts +
                '}';
    }
}
