package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private double unitPrice;
    private String unitType;
    private String remarks;

    public Product(String productName, double unitPrice, String unitType, String remarks) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitType = unitType;
        this.remarks = remarks;
    }

    @OneToMany(mappedBy = "product")
    private List<Product> products;
}
