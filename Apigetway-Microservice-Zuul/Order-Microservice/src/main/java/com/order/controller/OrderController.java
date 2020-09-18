package com.order.controller;


import com.order.model.OrderModel;
import com.order.repositroy.IOrderRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    IOrderRepository orderRepository;

    @PostMapping(value = "/save",produces = "application/json",consumes = "application/json")
    @ApiOperation(value = "post api for order",notes = "save order data")
    public ResponseEntity<String>createOrder(@RequestBody OrderModel orderModel){

        OrderModel order=orderRepository.save(orderModel);
        return ResponseEntity.ok("order create sucessfully"+"u r order id is"+"\t\t"+order.getId());
    }
    @GetMapping(value = "/getAllOrder",produces = "application/json",consumes = "application/json")
    @ApiOperation(value = "get order", notes = "get all customer order")
    public ResponseEntity<?>getAllOrder(){
        List<OrderModel> orderModelList=orderRepository.findAll();
        return ResponseEntity.ok(orderModelList);
    }
}
