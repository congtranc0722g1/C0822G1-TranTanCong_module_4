package com.the_song.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    private String name;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 300, message = "Không vượt quá 800 ký tự")
    private String singer;
    @NotEmpty(message = "Không được để trống")
    @Size(max = 1000, message = "Không vượt quá 800 ký tự")
    private String category;

    public SongDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
