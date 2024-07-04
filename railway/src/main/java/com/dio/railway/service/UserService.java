package com.dio.railway.service;

import com.dio.railway.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}