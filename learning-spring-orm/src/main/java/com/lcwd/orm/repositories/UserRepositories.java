package com.lcwd.orm.repositories;

import com.lcwd.orm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepositories extends JpaRepository<User, Integer> {

}
