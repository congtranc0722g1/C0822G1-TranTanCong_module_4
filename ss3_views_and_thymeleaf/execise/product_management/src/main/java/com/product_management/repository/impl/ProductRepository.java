package com.product_management.repository.impl;

import com.product_management.model.Product;
import com.product_management.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Mỳ Ăn Liền", 3000, "Ăn liên", "Acecook"));
        productList.add(new Product(2, "Sữa", 13000, "Sô cô la", "TH TrueMilk"));
        productList.add(new Product(3, "Xe Máy", 7000000, "Vario 150", "HonDa"));
        productList.add(new Product(4, "Cháo", 5000, "Ăn liên", "Hoa Sen"));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product searchById(int id) {
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                product = productList.get(i);
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        int index = findIndexById(product.getId());
        productList.set(index, product);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        productList.remove(index);
    }

    @Override
    public List<Product> search(String name_search) {
        List<Product> productList1 = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().contains(name_search)) {
                productList1.add(productList.get(i));
            }
        }
        return productList1;
    }

    @Override
    public Product detail(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return productList.get(i);
            }
        }
        return null;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
