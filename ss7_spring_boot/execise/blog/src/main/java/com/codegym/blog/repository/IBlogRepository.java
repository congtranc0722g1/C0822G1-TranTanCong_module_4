package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findBlog(@Param("id") int id);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findByCategoryId(int category, Pageable pageable);
}
