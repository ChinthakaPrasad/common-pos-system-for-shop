package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String phoneNumber;
    private String address;
    private String email;
    private String remarks;
}
