package com.example.rapphim.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ma;
    private String ten;
    @OneToMany(mappedBy = "phim")
    private Set<SuatChieu> suatChieus;

    public Phim() {
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<SuatChieu> getSuatChieus() {
        return suatChieus;
    }

    public void setSuatChieus(Set<SuatChieu> suatChieus) {
        this.suatChieus = suatChieus;
    }
}
