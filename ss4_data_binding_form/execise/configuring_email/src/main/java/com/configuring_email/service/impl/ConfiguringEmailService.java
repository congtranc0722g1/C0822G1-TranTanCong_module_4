package com.configuring_email.service.impl;

import com.configuring_email.model.ConfiguringEmail;
import com.configuring_email.repository.IConfiguringEmailRepository;
import com.configuring_email.service.IConfiguringEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguringEmailService implements IConfiguringEmailService {
    @Autowired
    private IConfiguringEmailRepository configuringEmailRepository;

    @Override
    public List<ConfiguringEmail> showAll() {
        return configuringEmailRepository.showAll();
    }

    @Override
    public ConfiguringEmail findById(int id) {
        return configuringEmailRepository.findById(id);
    }

    @Override
    public void update(ConfiguringEmail configuringEmail) {
        configuringEmailRepository.update(configuringEmail);
    }


}
