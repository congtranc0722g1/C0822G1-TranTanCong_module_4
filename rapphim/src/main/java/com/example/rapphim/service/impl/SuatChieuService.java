package com.example.rapphim.service.impl;

import com.example.rapphim.model.SuatChieu;
import com.example.rapphim.repository.ISuatChieuRepository;
import com.example.rapphim.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SuatChieuService implements ISuatChieuService {

    @Autowired
    private ISuatChieuRepository suatChieuRepository;

    @Override
    public Page<SuatChieu> findAll(Pageable pageable) {
        return suatChieuRepository.findAll(pageable);
    }

    @Override
    public SuatChieu findByMa(String ma) {
        return suatChieuRepository.findByMa(ma);
    }

    @Override
    public void delete(SuatChieu suatChieu) {
        suatChieuRepository.delete(suatChieu);
    }

    @Override
    public void save(SuatChieu suatChieu) {
        suatChieuRepository.save(suatChieu);
    }
}
