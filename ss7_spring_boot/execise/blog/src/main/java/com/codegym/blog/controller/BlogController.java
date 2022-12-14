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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        Page<Blog> blogList = blogService.findByCategoryId(categoryId, pageable);
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
    private String save(Blog blog, RedirectAttributes redirectAttributes) {
        boolean check = blogService.save(blog);
        String mess = "Th??m m???i kh??ng th??nh c??ng";
        if (check) {
            mess = "Th??m m???i th??nh c??ng";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
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
    private String edit(Blog blog, RedirectAttributes redirectAttributes) {
        boolean check = blogService.save(blog);
        String mess = "Ch???nh s???a kh??ng th??nh c??ng";
        if (check) {
            mess = "Ch???nh s???a th??nh c??ng";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
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
