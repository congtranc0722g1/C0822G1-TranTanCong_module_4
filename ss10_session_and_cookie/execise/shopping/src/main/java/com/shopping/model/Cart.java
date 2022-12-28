package com.shopping.model;


import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            Integer cur = products.get(product);
            products.replace(product, cur + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void decreaseProduct(Product product) {
        if (products.containsKey(product)) {
            Integer cur = products.get(product);
            if (cur > 1) {
                products.replace(product, cur - 1);
            } else {
                products.remove(product);
            }
        }
    }

    public void payCart() {
        products.clear();
    }

    public int countTotalPayment() {
        int payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return payment;
    }
}
