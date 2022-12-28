package com.book.service.impl;

import com.book.model.BookCode;
import com.book.repository.IBookCodeRepository;
import com.book.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookCodeService implements IBookCodeService {

    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public Optional<BookCode> findById(int id) {
        return bookCodeRepository.findById(id);
    }
}
