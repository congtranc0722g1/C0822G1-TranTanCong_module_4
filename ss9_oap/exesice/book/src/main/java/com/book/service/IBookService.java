package com.book.service;

import com.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(int id);
//
    int borrowBook(int id) throws Exception;
//
    void giveBook(int id);
}
