package dto.tm;

import dto.OrderItemDetailDto;
import javafx.scene.control.Button;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Setter
@Getter
public class OrderTm {
    private String orderId;
    private String customerName;
    private double totalPrice;
    private String date;
    private Button view;
    private List<OrderItemDetailDto> orderItemDetails;
}
