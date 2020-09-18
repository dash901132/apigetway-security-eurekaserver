package com.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.soap.SAAJResult;
import java.util.UUID;

@Document(collation = "order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String id= UUID.randomUUID().toString();
    protected String orderId=UUID.randomUUID().toString();
    protected String address;
    protected String cname;

}
