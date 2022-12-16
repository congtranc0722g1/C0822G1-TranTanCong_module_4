package com.configuring_email.repository.impl;

import com.configuring_email.model.ConfiguringEmail;
import com.configuring_email.repository.IConfiguringEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfiguringEmailRepository implements IConfiguringEmailRepository {
    private static List<ConfiguringEmail> configuringEmailList = new ArrayList<>();
    static {
        configuringEmailList.add(new ConfiguringEmail(1, "English", 5, true, "Thor"));
        configuringEmailList.add(new ConfiguringEmail(2, "Vietnamese", 10, false, "John"));
        configuringEmailList.add(new ConfiguringEmail(3, "Japanese", 25, true, "David"));
    }

    @Override
    public List<ConfiguringEmail> showAll() {
        return configuringEmailList;
    }

    @Override
    public ConfiguringEmail findById(int id) {
        ConfiguringEmail configuringEmail = null;
        for (int i = 0; i < configuringEmailList.size(); i++) {
            if(id == configuringEmailList.get(i).getId()){
                configuringEmail = configuringEmailList.get(i);
            }
        }
        return configuringEmail;
    }

    @Override
    public void update(ConfiguringEmail configuringEmail) {
        int index = findIndexById(configuringEmail.getId());
        configuringEmailList.set(index, configuringEmail);

    }

    public int findIndexById (int id){
        for (int i = 0; i < configuringEmailList.size(); i++) {
            if(configuringEmailList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
