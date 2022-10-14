package com.example.demoproduct.repository;
import com.example.demoproduct.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends MongoRepository<Orders, String> {

    List<Orders> findOrdersByUserId(String userId);

    List<Orders> findOrdersByUserIdOrderByCreatedDesc(String userId);
}
