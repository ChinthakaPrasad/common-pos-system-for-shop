package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    private String supplierName;
    private String phoneNumber;
    private String address;
    private String email;
    private String remarks;

    public Supplier(String supplierName, String phoneNumber, String address, String email, String remarks) {
        this.supplierName = supplierName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.remarks = remarks;
    }
}
