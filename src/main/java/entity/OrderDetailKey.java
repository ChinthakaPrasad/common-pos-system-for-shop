package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "order_Id")
    private String orderId;

    @Column(name = "product_Id")
    private int productId;
}
