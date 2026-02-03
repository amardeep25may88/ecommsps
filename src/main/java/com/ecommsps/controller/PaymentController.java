package com.ecommsps.controller;

import com.ecommsps.entity.Payment;
import com.ecommsps.enums.PaymentStatus;
import com.ecommsps.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<Map<String,Object>>createPayment(@RequestBody Payment payment){
        Payment newPayment=paymentService.createNewPayment(payment);
        Map<String, Object> newPaymentMap = new HashMap<>();
        newPaymentMap.put("message", "Payment created");
        newPaymentMap.put("count", 1);
        newPaymentMap.put("data", newPayment);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(newPaymentMap);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Payment>> getAll(){
        List<Payment> paymentsList=paymentService.getAllPayments();
        if(!paymentsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(paymentsList);
        }else
            return  ResponseEntity.noContent().build();
    }

    @GetMapping("/getById/{id}")
    ResponseEntity<Optional<Payment>> getById(@PathVariable Long id){
        Optional<Payment> newPayment=paymentService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(newPayment);
    }

    @GetMapping("/getByStatus/{paymentStatus}")
    ResponseEntity<List<Payment>> getByStatus(@PathVariable PaymentStatus paymentStatus){
        List<Payment> paymentsList=paymentService.getByStatus(paymentStatus);
        if(paymentsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(paymentsList);
        }else
            return  ResponseEntity.noContent().build();
    }




}
