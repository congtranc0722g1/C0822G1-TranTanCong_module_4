package com.example.rapphim.service.impl;

import com.example.rapphim.model.Phim;
import com.example.rapphim.repository.IPhimRepository;
import com.example.rapphim.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimService implements IPhimService {

    @Autowired
    private IPhimRepository phimRepository;

    @Override
    public List<Phim> findAll() {
        return phimRepository.findAll();
    }
}
