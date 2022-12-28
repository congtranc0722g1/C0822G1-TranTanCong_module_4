package com.book.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    private int bookCode;
    private int id;

    public BookCode() {

    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
