package com.ecommsps.service;

import com.ecommsps.entity.Payment;
import com.ecommsps.enums.PaymentStatus;
import com.ecommsps.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment createNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getByStatus(PaymentStatus paymentStatus) {
        return paymentRepository.getByStatus(paymentStatus);

    }
}
