package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void delete(Blog blog);

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void edit(Blog blog);

    Blog findBlog(int id);

    List<Blog> findByTitleContaining(String title);
}
