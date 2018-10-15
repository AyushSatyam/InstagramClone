package com.example.a07ayu.instagramclone.Model;

public class GetInfo {
    private String username,email,password,user_id;
    long phone_number;
    public GetInfo() {

    }
    public GetInfo(String username, String email, String password, String user_id, long phone_number) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.user_id = user_id;
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "GetInfo{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_id='" + user_id + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }
}
