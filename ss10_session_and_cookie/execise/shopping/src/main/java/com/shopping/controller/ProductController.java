package com.shopping.controller;

import com.shopping.model.Cart;
import com.shopping.model.Product;
import com.shopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showShop(Model model, @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("productAdvertisement", productService.findById(idProduct).get());
        }
        model.addAttribute("productList", productService.findAll());
        return "/shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, Model model, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        cart.addProduct(product.get());
        return "redirect:/cart";
    }


    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Long id, Model model, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        cart.decreaseProduct(product.get());
        return "redirect:/cart";
    }

    @GetMapping("/detail/{id}")
    public String showProduct(@PathVariable Long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id).get());
        return "/detail";
    }

    @PostMapping("/pay")
    public String pay(@SessionAttribute("cart") Cart cart, Model model) {
        cart.payCart();
        return "redirect:/cart";
    }
}
