package com.socialApp.socialApp.serviceImpl;

import com.socialApp.socialApp.model.User;
import com.socialApp.socialApp.repository.UserRepository;
import com.socialApp.socialApp.request.UserRequest;
import com.socialApp.socialApp.response.UserResponse;
import com.socialApp.socialApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(UserRequest request) {
        User entity = new User ( );
        entity.setEmail ( request.getEmail ( ) );
        entity.setUserName ( request.getUserName ( ) );
        entity.setPassword ( request.getPassword ( ) );
        return repository.save ( entity );
    }

    @Override
    public UserResponse findUserByUserId(Long userId) {
        return new UserResponse (
                repository.findById ( userId )
                        .orElseThrow ( () ->
                                new RuntimeException ( "Id not found" ) ) );
    }

    @Override
    public List<UserResponse> findAllUser() {
        List<User> all = repository.findAll ( );
        return all.stream ( ).map ( UserResponse::new ).toList ( );
    }

    @Override
    public UserResponse updateUserByUserId(Long userId, UserRequest request) {
        User user = repository.findById ( userId )
                .orElseThrow ( () -> new RuntimeException ( "user not found" ) );

        if ( request.getUserName ( ) != null )
            user.setUserName ( request.getUserName ( ) );

        if ( request.getEmail ( ) != null )
            user.setEmail ( request.getEmail ( ) );

        if ( request.getPassword ( ) != null )
            user.setPassword ( request.getPassword ( ) );

        return new UserResponse ( user );
    }

    @Override
    public void deleteUserByUserId(Long userId) {
        User user = repository.findById ( userId ).orElseThrow ( () -> new RuntimeException ( "Id not found" ) );
        repository.delete ( user );

    }
}
