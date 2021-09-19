package com.siva;

public class User {
    private int userId;
    private String userName;
    private String password;
    private boolean isValidated;
    public User(String userName, boolean isValidated) {
        this.userName = userName;
        this.isValidated = isValidated;
    }
    public int getUserId() {
        return userId;
    }
    public boolean isValidated() {
        return isValidated;
    }
    public void setValidated(boolean isValidated) {
        this.isValidated = isValidated;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
