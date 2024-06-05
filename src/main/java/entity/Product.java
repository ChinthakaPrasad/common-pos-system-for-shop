package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String productName;
    private double sellingUnitPrice;
    private double buyingUnitPrice;
    private String supplier;
    private String unitType;
    private String remarks;

    public Product(String productName, double sellingUnitPrice, double buyingUnitPrice, String supplier, String unitType, String remarks) {
        this.productName = productName;
        this.sellingUnitPrice = sellingUnitPrice;
        this.buyingUnitPrice = buyingUnitPrice;
        this.supplier = supplier;
        this.unitType = unitType;
        this.remarks = remarks;
    }

    @OneToMany(mappedBy = "product")
    private List<OrderItemDetail> orderItemDetails = new ArrayList<>();
}
