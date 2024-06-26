package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SupplierDto {
    private int supplierId;
    private String supplierName;
    private String supplierPhone;
    private String supplierAddress;
    private String supplierEmail;
    private String remarks;
}
