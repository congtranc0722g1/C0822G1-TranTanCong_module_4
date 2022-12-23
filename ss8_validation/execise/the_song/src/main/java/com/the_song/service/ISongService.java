package com.the_song.service;

import com.the_song.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Optional<Song> findById(int id);

    void edit(Song song);
}
