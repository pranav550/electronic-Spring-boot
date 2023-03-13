package com.lcwd.orm.services.Impl;

import com.lcwd.orm.entities.User;
import com.lcwd.orm.repositories.UserRepositories;
import com.lcwd.orm.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepositories userRepository;
    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        logger.info("User Saved:{}",savedUser.getId());
        return savedUser;
    }

    @Override
    public User updateUser(User user, int userId) {
        //1.user get database
        User user1 = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given id not found"));
        user1.setName(user.getName());
        user1.setCity(user.getCity());
        user1.setAge(user.getAge());
        //2.update user
        User user2 = userRepository.save(user1);
        return user2;
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found with given Id"));
        userRepository.delete(user);
        logger.info("user deleted");
    }
// to get all user
    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
// get single user by id
    @Override
    public User getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new RuntimeException("User With given id not found"));
        return user;
    }
}
