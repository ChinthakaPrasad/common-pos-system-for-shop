package dto;

import entity.OrderItemDetail;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {
    private String orderId;
    private String customerName;
    private double totalPrice;
    private String date;
    private List<OrderItemDetailDto> orderItemDetails;
}
