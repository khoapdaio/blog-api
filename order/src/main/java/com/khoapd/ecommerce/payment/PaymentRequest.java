package com.khoapd.ecommerce.payment;

import com.khoapd.ecommerce.customer.CustomerResponse;
import com.khoapd.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}