package com.book.service;

import com.book.model.BookCode;

import java.util.Optional;

public interface IBookCodeService {
    Optional<BookCode> findById(int id);
}
