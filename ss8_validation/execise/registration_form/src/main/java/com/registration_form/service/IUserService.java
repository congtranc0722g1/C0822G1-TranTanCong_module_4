package com.registration_form.service;

import com.registration_form.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void save(User user);
}
