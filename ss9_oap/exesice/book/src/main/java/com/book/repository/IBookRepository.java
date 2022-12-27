package com.book.repository;

import com.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Book findByBookCode_BookCode(int code);
}
