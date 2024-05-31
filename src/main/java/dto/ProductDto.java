package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductDto {
    private int productId;
    private String productName;
    private double unitPrice;
    private String unitType;
    private String remarks;
}
