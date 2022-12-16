package com.configuring_email.repository;

import com.configuring_email.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailRepository {
    List<ConfiguringEmail> showAll();

    ConfiguringEmail findById(int id);

    void update(ConfiguringEmail configuringEmail);
}
