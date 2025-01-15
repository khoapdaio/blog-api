package com.khoapd.ecommerce.orderline;

import com.khoapd.ecommerce.order.model.Order;
import com.khoapd.ecommerce.orderline.model.OrderLine;
import com.khoapd.ecommerce.orderline.model.OrderLineRequest;
import com.khoapd.ecommerce.orderline.model.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
