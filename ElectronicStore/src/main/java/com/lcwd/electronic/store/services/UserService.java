package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.PageableResponse;
import com.lcwd.electronic.store.dtos.UserDto;
import com.lcwd.electronic.store.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserService {

    // create
    UserDto createUser(UserDto userDto);

    // get all user
    PageableResponse<UserDto> getAllUser(int pageNumber, int pageSize, String sortBy, String sortDir);

    // get user  by id
    UserDto getUserById(String userId);
    // get user by email
    UserDto getUserByEmail(String email);
    // update
    UserDto updateUser(UserDto userDto, String userId);
    //delete
    void deleteUser(String userId);

    // search user
    List<UserDto> searchUser(String keyword);


    Optional<User> findUserByEmailOptional(String email);

    // other user specific features



}
