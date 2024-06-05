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
    private double sellingUnitPrice;
    private double buyingUnitPrice;
    private String supplier;
    private String unitType;
    private String remarks;
    private Button btn;

}
