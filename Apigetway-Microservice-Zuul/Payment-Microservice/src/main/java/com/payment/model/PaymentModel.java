package com.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id= UUID.randomUUID().toString();
    protected LocalDateTime paymentsDate=LocalDateTime.now();
    protected String txId=UUID.randomUUID().toString();
    protected int paidAmount;
}
