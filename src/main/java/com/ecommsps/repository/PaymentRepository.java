package com.ecommsps.repository;

import com.ecommsps.entity.Payment;
import com.ecommsps.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> getByStatus(PaymentStatus paymentStatus);

}
