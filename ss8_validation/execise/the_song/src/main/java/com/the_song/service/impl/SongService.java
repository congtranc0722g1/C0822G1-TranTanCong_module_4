package com.the_song.service.impl;

import com.the_song.model.Song;
import com.the_song.repository.ISongRepository;
import com.the_song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void edit(Song song) {
        songRepository.save(song);
    }
}
