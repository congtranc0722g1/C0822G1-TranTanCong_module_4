package com.book.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    private Integer id;
    private String name;
    private String author;
    private Integer amount;

    @OneToOne(mappedBy = "book")
    private BookCode bookCode;

    public Book() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BookCode getBookCode() {
        return bookCode;
    }

    public void setBookCode(BookCode bookCode) {
        this.bookCode = bookCode;
    }
}
