package com.product_management.service.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> showAll() {
        return productRepository.showAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product searchById(int id) {
        return productRepository.searchById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

    @Override
    public List<Product> search(String nameSearch) {
        return productRepository.search(nameSearch);
    }

    @Override
    public Product detail(int id) {
        return null;
    }
}
