package com.configuring_email.service;

import com.configuring_email.model.ConfiguringEmail;

import java.util.List;

public interface IConfiguringEmailService {
    List<ConfiguringEmail> showAll();

    ConfiguringEmail findById(int id);

    void update(ConfiguringEmail configuringEmail);
}
