package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemDetailDto {
    private int orderId;
    private int productId;
    private double amount;
    private double qty;
}
