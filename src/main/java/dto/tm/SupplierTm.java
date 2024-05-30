package dto.tm;

import javafx.scene.control.Button;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SupplierTm {
    private int supplierId;
    private String supplierName;
    private String supplierPhone;
    private String supplierAddress;
    private String supplierEmail;
    private String remarks;
    private Button btn;
}
