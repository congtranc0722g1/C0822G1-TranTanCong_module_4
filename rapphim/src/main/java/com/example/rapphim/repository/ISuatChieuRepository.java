package com.example.rapphim.repository;

import com.example.rapphim.model.SuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISuatChieuRepository extends JpaRepository<SuatChieu, String> {

    @Query(value = "select  * from suat_chieu where ma = :ma", nativeQuery = true)
    SuatChieu findByMa(@Param("ma") String ma);
}
