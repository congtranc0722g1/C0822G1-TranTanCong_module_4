package com.example.rapphim.repository;

import com.example.rapphim.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhimRepository extends JpaRepository<Phim, Integer> {
}
