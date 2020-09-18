package com.payment.repositroy;

import com.payment.model.PaymentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPaymentRepositroy  extends MongoRepository<PaymentModel,String> {
}
