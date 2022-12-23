package com.the_song.service;

import com.the_song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);
}
