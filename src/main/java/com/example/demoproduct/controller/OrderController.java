package com.example.demoproduct.controller;

import com.example.demoproduct.model.Orders;
import com.example.demoproduct.request.OrderRequest;
import com.example.demoproduct.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;


    @PostMapping
    public void addOrders(@RequestBody final OrderRequest orderRequest) {
        orderService.addNewOrders(orderRequest);
    }

    @GetMapping
    public List<Orders> checkOrders()
    {
        return  orderService.checkForOrders();
    }

    @GetMapping("/{userId}")
    public List<Orders> findOrder(@PathVariable final String userId){
        return orderService.findOrderById(userId);
    }


    @GetMapping("/orders/{userId}")
    public List<Orders> findOrderInReverse(@PathVariable final String userId){
        return orderService.findOrder(userId);
    }

}
