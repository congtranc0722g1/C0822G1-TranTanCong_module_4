package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private String showListBlog(@RequestParam(name = "search", defaultValue = "") String search, Model model, @PageableDefault(size = 2) Pageable pageable) {
//        List<Blog> blogList = blogService.findAll();
//        model.addAttribute("blogList", blogList);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        Page<Blog> blogList = blogService.findByTitleContaining(search, pageable);
        model.addAttribute("blogList", blogList);
        model.addAttribute("search", search);
        return "blog/list";
    }

    @GetMapping("/category")
    private String category(@RequestParam(name = "category", defaultValue = "") Integer categoryId, @PageableDefault(size = 2) Pageable pageable, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        Page<Blog> blogList = blogService.findByCategory_Id(categoryId, pageable);
        model.addAttribute("blogList", blogList);
        model.addAttribute("categoryId", categoryId);
        return "blog/list";
    }

    @GetMapping("/add")
    private String showListCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/add")
    private String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    private String showFormEdit(@PathVariable("id") int id, Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit";
    }

    @PostMapping("/edit")
    private String edit(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    private String detail(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.findBlog(id));
        return "blog/detail";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam("id") int id) {
        Blog blog = blogService.findBlog(id);
        blogService.delete(blog);
        return "redirect:/";
    }

//    @GetMapping("/search")
//    private String search(@RequestParam(name = "search", defaultValue = "") String search, Model model) {
//        List<Blog> blogList = blogService.findByTitleContaining(search);
//        model.addAttribute("blogList", blogList);
//        model.addAttribute("search", search);
//        return "blog/list";
//    }
}
