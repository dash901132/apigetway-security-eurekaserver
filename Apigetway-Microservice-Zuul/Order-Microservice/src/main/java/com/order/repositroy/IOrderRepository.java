package com.order.repositroy;


import com.order.model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderRepository extends MongoRepository<OrderModel,String> {
}
