package com.example.demoproduct.controller;

import com.example.demoproduct.service.CancelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cancels")
@AllArgsConstructor
public class CancelController {

    private CancelService cancelService;

    @PostMapping("/{Id}")
    public void cancelOrders(@PathVariable final String Id) {
        cancelService.cancelNewOrders(Id);
    }
}
