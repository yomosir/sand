package org.zheng.sand.user.entity;

public class UserInfo {
    private String uiId;

    private String mName;

    private String nickName;

    private Integer gender;

    private String description;

    private String email;

    private String phone;

    private String picture;

    public String getUiId() {
        return uiId;
    }

    public void setUiId(String uiId) {
        this.uiId = uiId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uiId='" + uiId + '\'' +
                ", mName='" + mName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}