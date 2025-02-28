package com.socialApp.socialApp.service;

import com.socialApp.socialApp.model.User;
import com.socialApp.socialApp.request.UserRequest;
import com.socialApp.socialApp.response.UserResponse;

import java.util.List;

public interface UserService {
    public User createUser(UserRequest request);

    public UserResponse findUserByUserId(Long userId);

    public List<UserResponse> findAllUser();

    public UserResponse updateUserByUserId(Long userId, UserRequest request);

    public void deleteUserByUserId(Long userId);


}
