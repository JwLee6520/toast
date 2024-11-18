package kr.hs.sdh.toast.entity;

import java.beans.ConstructorProperties;

public class LoginInfo {
    private String userId;
    private String userPassword;
    @ConstructorProperties(value = {"userId", "userPassword"})
    public LoginInfo(String userId, String userPassword){
        this.userId = userId;
        this.userPassword = userPassword;
    }
    public String getUserId(){
        return userId;
    }
    public String getUserPassword(){
        return userPassword;
    }

}
