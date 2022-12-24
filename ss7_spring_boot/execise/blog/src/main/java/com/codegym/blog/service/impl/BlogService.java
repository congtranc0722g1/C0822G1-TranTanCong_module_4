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
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public boolean save(Blog blog) {
        for (int i = 0; i < blogRepository.findAll().size(); i++) {
            if (blogRepository.findAll().get(i).getTitle().equals(blog.getTitle())) {
                return false;
            }
        }
        blogRepository.save(blog);
        return true;
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public boolean edit(Blog blog) {
        for (int i = 0; i < blogRepository.findAll().size(); i++) {
            if (blogRepository.findAll().get(i).getTitle().equals(blog.getTitle())) {
                return false;
            }
        }
        blogRepository.save(blog);
        return true;
    }

    @Override
    public Blog findBlog(int id) {
        return blogRepository.findBlog(id);
    }

    @Override
    public Page<Blog> findByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findByCategory_Id(int category, Pageable pageable) {
        return blogRepository.findByCategory_Id(category, pageable);
    }


}
