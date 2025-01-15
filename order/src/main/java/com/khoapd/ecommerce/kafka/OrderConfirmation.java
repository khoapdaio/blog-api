package com.khoapd.ecommerce.kafka;

import com.khoapd.ecommerce.customer.CustomerResponse;
import com.khoapd.ecommerce.order.PaymentMethod;
import com.khoapd.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}