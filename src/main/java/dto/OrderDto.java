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
    private int orderId;
    private String customerName;
    private String date;
    private List<OrderItemDetailDto> orderItemDetails;
}
