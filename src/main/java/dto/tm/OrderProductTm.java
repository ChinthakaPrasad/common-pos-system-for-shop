package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

import java.util.PrimitiveIterator;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderProductTm {
    private int productId;
    private String productName;
    private double qty;
    private double discount;
    private double amount;
    private String remarks;
    private Button btn;
    private String supplier;
}
