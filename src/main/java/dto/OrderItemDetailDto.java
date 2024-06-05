package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDetailDto {
    private String orderId;
    private int productId;
    private double amount;
    private double qty;
    private String supplierName;
}
