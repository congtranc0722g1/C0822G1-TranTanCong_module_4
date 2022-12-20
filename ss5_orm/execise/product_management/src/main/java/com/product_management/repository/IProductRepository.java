package com.product_management.repository;

import com.product_management.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();

    void add(Product product);

    Product searchById(int id);

    void update(Product product);

    void remove(Product product);

    List<Product> search(String nameSearch);

    void removeModal(int id);
}
