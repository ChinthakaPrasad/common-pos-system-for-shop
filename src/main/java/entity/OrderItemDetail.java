package entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItemDetail {

    @EmbeddedId
    OrderDetailKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    private String supplierName;
    private double qty;
    private double amount;
}
