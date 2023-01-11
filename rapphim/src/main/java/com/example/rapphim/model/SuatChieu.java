package com.example.rapphim.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class SuatChieu {
    @Id
    @Column(columnDefinition = "varchar(7)")
    private String ma;
    @Column(columnDefinition = "date")
    private String ngayChieu;
    private Integer soLuong;
    @ManyToOne
    @JoinColumn(name = "phim_id", nullable = false, referencedColumnName = "ma")
    private Phim phim;

    public SuatChieu() {
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }
}
