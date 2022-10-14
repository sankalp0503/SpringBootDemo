package com.example.demoproduct.service;

import com.example.demoproduct.model.Orders;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.repository.OrderRepository;
import com.example.demoproduct.repository.ProductRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Optional;

@AllArgsConstructor
@Service
public class CancelService {




    private OrderRepository orderRepository;

    private ProductRepository productRepository;

    private final String cancel="CANCELLED";


    //Post
    public void cancelNewOrders(@PathVariable final String Id) {
        Optional<Orders> userCancel = orderRepository.findById(Id);
        if (userCancel.isPresent()) {

            Orders order = userCancel.get();

                Optional<Product> prodOptional = productRepository
                        .findById(order.getProductId());
                if (prodOptional.isPresent()) {

                    Product product = prodOptional.get();
                    product.setQuantity(product.getQuantity().add(order.getQuantity()));


                    if(order.getStatus().equals(cancel)){
                        throw new RuntimeException("order is already cancelled");
                    }

                    productRepository.save(product);


                    order.setQuantity(null);
                    order.setStatus("CANCELLED");

                    orderRepository.save(order);

                }
            }
            }
        }




