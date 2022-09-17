package com.lwq.service;

import com.lwq.domain.User;
import java.util.List;


public interface UserService {

    List<User> findAll();

    User findByID(Integer id);

    void addUser(User user);

    void updUser(User user);

    void delUser(Integer id);



}
