package com.payment.controller;


import com.payment.model.PaymentModel;
import com.payment.repositroy.IPaymentRepositroy;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    IPaymentRepositroy paymentRepositroy;
    @PostMapping(value = "/save",produces = "application/json",consumes = "application/json")
    @ApiOperation(value = "post api for payment",notes = "save  payment data")
    public ResponseEntity<String> createOrder(@RequestBody PaymentModel paymentModel){

        PaymentModel order=paymentRepositroy.save(paymentModel);
        return ResponseEntity.ok("payment done sucessfully"+"u r ransaction id  id is"+"\t\t"+order.getTxId());
    }
    @GetMapping("/getAllpayments")
    @ApiOperation(value = "get all payments", notes = "get all payments details")
    public ResponseEntity<?>getAllOrder(){
        List<PaymentModel> orderModelList=paymentRepositroy.findAll();
        return ResponseEntity.ok(orderModelList);
    }
}
