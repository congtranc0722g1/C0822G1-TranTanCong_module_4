package com.product_management.controller;

import com.product_management.model.Product;
import com.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    private String showListProduct(Model model) {
        List<Product> productList = productService.showAll();
        model.addAttribute("productList", productList);
        return "/product/list";
    }

    @GetMapping("/add")
    private String showListCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/product/create";
    }

    @PostMapping("/add")
    private String save(Product product) {
        productService.add(product);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    private String showFormEdit(@PathVariable("id") int id, Model model) {
        Product product = productService.searchById(id);
        model.addAttribute("product", product);
        return "/product/edit";
    }

    @PostMapping("/edit")
    private String edit(Product product) {
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    private String showFormDelete(@PathVariable("id") int id, Model model) {
        Product product = productService.searchById(id);
        model.addAttribute("product", product);
        return "/product/delete";
    }

    @PostMapping("/delete")
    private String delete(int id) {
        productService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search/{search}")
    private String search(@RequestParam("search") String name_search, Model model) {
        List<Product> productList = productService.search(name_search);
        model.addAttribute("productList", productList);
        return "/product/list";
    }

    @GetMapping("/detail/{id}")
    private String detail(@PathVariable("id") int id, Model model) {
        Product product = productService.detail(id);
        model.addAttribute("product", product);
        return "/product/detail";
    }

}
