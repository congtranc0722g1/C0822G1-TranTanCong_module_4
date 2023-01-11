package com.example.rapphim.service;

import com.example.rapphim.model.SuatChieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISuatChieuService {
    Page<SuatChieu> findAll(Pageable pageable);

    SuatChieu findByMa(String ma);

    void delete(SuatChieu suatChieu);

    void save(SuatChieu suatChieu);
}
