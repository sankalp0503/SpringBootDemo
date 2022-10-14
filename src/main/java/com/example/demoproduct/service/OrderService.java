package com.example.demoproduct.service;

import com.example.demoproduct.model.Orders;
import com.example.demoproduct.model.Product;
import com.example.demoproduct.model.User;
import com.example.demoproduct.repository.OrderRepository;
import com.example.demoproduct.repository.ProductRepository;
import com.example.demoproduct.repository.UserRepository;
import com.example.demoproduct.request.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service

public class OrderService {


    private OrderRepository orderRepository;


    private UserRepository userRepository;


    private ProductRepository productRepository;


    //Post
    public void addNewOrders(@RequestBody final OrderRequest orderRequest) {
        Optional<User> userOptional = userRepository
                .findById(orderRequest.getUserId());
        if (userOptional.isPresent()) {
            Optional<Product> prodOptional = productRepository
                    .findById(orderRequest.getProductId());
            if (prodOptional.isPresent()) {
                Product product = prodOptional.get();
                User user= userOptional.get();

//                System.out.println(product.getQuantity().intValue());
//                System.out.println(orderRequest.getQuantity().intValue());
//                System.out.println(user.getAddress());

                if(product.getQuantity().intValue() > orderRequest.getQuantity().intValue()){
                    product.setQuantity(product.getQuantity().subtract(orderRequest.getQuantity()));




                    productRepository.save(product);





                    Orders order= new Orders();
                    order.setQuantity(orderRequest.getQuantity());
                    order.setProductId(orderRequest.getProductId());
                    order.setUserId(orderRequest.getUserId());
                    order.setUserAddress(user.getAddress());
                    order.setStatus("Order is placed");
                    orderRepository.save(order);
                }

            }
        }


    }


    //GetAll
    public List<Orders> checkForOrders() {
        return orderRepository.findAll();
    }


    //GetById
    public List<Orders> findOrderById( @PathVariable final String userId) {
        return orderRepository.findOrdersByUserId(userId);}



    //GetByorder of update
    public List<Orders> findOrder(@PathVariable final String userId){
        return orderRepository.findOrdersByUserIdOrderByCreatedDesc(userId);
    }

}
