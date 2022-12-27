package com.book.repository;

import com.book.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCodeRepository extends JpaRepository<BookCode, Integer> {
    BookCode deleteByBookCode(Integer code);
}
