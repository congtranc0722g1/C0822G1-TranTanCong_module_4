package com.product_management.service;

import com.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();

    void add(Product product);

    Product searchById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> search(String name_search);

    Product detail(int id);
}
