package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findBlog(int id) {
        return blogRepository.findBlog(id);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findByTitleContaining(String title) {
        return blogRepository.findByTitleContaining(title);
    }


}
