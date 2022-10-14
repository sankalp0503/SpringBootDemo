package com.example.demoproduct.service;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.repository.ProductRepository;
import com.example.demoproduct.request.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@AllArgsConstructor
@Service
public class ProductService {


    private ProductRepository productRepository;



    //Post
    public void addAllProducts(@RequestBody final Product product){
        Optional<Product> productOptional=productRepository
                .findProductByModelNumber(product.getModelNumber()); // taking anothr field as unique key so that if same with another goes it doe not add as new data
        if(productOptional.isPresent()){
            throw new RuntimeException("modelNumber taken");
        }
        productRepository.save(product);

    }




    //Get
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }



    //GetById
    public Product findProductById(@PathVariable final String productId){
        return productRepository.findById(productId).orElseGet(Product::new);
    }


    //Delete
    public ResponseEntity deleteProductById(@PathVariable final String productId) {

        Optional<Product> product = productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.deleteById(productId);
            return ResponseEntity.ok("Success");
        } else {
            return  ResponseEntity.badRequest().body("the product with id:" + productId + "was not found");
        }
    }


    //Put
    public void updateProductById(@PathVariable final String productId, @RequestBody ProductRequest product){
        Product savedProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot find productby id %s ",productId)));

        savedProduct.setName(product.getName());
        savedProduct.setModelNumber(product.getModelNumber());
        savedProduct.setQuantity(product.getQuantity());
        savedProduct.setBrand(product.getBrand());
        savedProduct.setUrl(product.getUrl());
        savedProduct.setImage(product.getImage());


        productRepository.save(savedProduct);

    }

}
