package com.ssafy.happyhouse.model;

public class UserDto {
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userPreferArea;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPreferArea() {
        return userPreferArea;
    }

    public void setPreferArea(String userPreferArea) {
        this.userPreferArea = userPreferArea;
    }
}
