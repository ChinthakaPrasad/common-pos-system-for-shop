package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderItemTm {
    private String orderId;
    private String productName;
    private int productId;
    private double amount;
    private double qty;
    private String supplier;
}
