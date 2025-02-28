package com.socialApp.socialApp.response;

import com.socialApp.socialApp.model.User;

public class UserResponse {
    private Long userId;
    private String userName;
    private String email;


    public UserResponse(User source) {
        this.email = source.getEmail ( );
        this.userId = source.getUserId ( );
        this.userName = source.getUserName ( );
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
