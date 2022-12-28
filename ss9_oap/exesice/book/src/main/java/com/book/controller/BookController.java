package com.book.controller;

import com.book.model.Book;
import com.book.model.BookCode;
import com.book.service.IBookCodeService;
import com.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookCodeService bookCodeService;

    @GetMapping("")
    private String showListBook(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }

    @GetMapping("/detail/{id}")
    private String showDetail(@PathVariable("id") int id, Model model){
        Optional<Book> book = bookService.findById(id);
        model.addAttribute("book", book.get());
        return "book/detail";
    }

    @PostMapping("/borrow")
    private String borrowBook(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) throws Exception {
         int code = bookService.borrowBook(id);
         BookCode bookCode = bookCodeService.findById(code).orElse(null);
         redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công với mã: " + bookCode.getBookCode());
         return "redirect:/book";
    }

    @GetMapping("/give")
    private String giveBook(@RequestParam("code") Integer code, RedirectAttributes redirectAttributes) {
        bookService.giveBook(code);
        redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/book";
    }
}
