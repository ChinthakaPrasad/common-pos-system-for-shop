package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductTm {
    private int productId;
    private String productName;
    private double unitPrice;
    private String unitType;
    private String remarks;
    private Button btn;

}
