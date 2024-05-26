package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private String customerName;
    private Date date;

    public Order(String customerName, Date date) {
        this.customerName = customerName;
        this.date = date;
    }

    @OneToMany(mappedBy = "order")
    private List<OrderItemDetail> orderItemDetails;


}
