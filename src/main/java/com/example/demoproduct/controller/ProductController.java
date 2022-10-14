package com.example.demoproduct.controller;


import com.example.demoproduct.model.Product;
import com.example.demoproduct.request.ProductRequest;
import com.example.demoproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {


    private ProductService productService;



    @PostMapping
    public void addProducts(@RequestBody final Product product){
        productService.addAllProducts(product);

    }




    @GetMapping
    public List<Product> findProducts(){
        return productService.findAllProducts();
    }



    @GetMapping("/{productId}")
    public Product findProduct(@PathVariable final String productId){
        return productService.findProductById(productId);
    }


    @DeleteMapping("/{productId}")
    public void delete(@PathVariable final String productId) {
        productService.deleteProductById(productId);

    }


     @PutMapping("/{productId}")
      public void update(@PathVariable final String productId, @RequestBody ProductRequest product){
        productService.updateProductById(productId,product);

     }






}
