package com.khoapd.ecommerce.orderline.model;

import com.khoapd.ecommerce.order.model.Order;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OptimisticLock;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer_line")
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @OptimisticLock(excluded = true)
    private Order order;
    private Integer productId;
    private double quantity;
}