package dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CustomerTm {
    private int customerId;
    private String customerName;
    private String phoneNumber;
    private String nic;
    private String remarks;
    private Button btn;
}
