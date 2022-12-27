package com.book.service.impl;

import com.book.model.Book;
import com.book.model.BookCode;
import com.book.repository.IBookCodeRepository;
import com.book.repository.IBookRepository;
import com.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void borrowBook(int id) {
        Book book = null;
        try {
            book = bookRepository.findById(id).get();
            if (book.getAmount() <= 0) {
                throw new Exception();
            }
            book.setAmount(book.getAmount() - 1);
            bookRepository.save(book);
            int code = (int) Math.floor(((Math.random() * 89999) + 10000));
            BookCode bookCode = new BookCode();
            bookCode.setBookCode(code);
            bookCode.getBook().setId(book.getId());
            bookCodeRepository.save(bookCode);
        } catch (Exception e) {

        }
    }

    @Override
    public void giveBook(int code) {
        Book book = bookRepository.findByBookCode_BookCode(code);
        book.setAmount(book.getAmount() + 1);
        bookRepository.save(book);
        bookCodeRepository.deleteByBookCode(code);
    }
}
