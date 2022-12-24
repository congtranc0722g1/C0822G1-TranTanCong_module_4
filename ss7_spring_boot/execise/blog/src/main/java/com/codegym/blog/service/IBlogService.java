package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void delete(Blog blog);

    boolean save(Blog blog);

    Optional<Blog> findById(int id);

    boolean edit(Blog blog);

    Blog findBlog(int id);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findByCategory_Id(int category, Pageable pageable);
}
