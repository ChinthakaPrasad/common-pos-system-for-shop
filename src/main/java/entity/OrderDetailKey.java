package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "orderId")
    int orderID;

    @Column(name = "productId")
    int productId;
}
