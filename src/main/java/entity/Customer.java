package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Customer {

   private String customerId;
   private String customerName;
   private String phoneNumber;
   private String nic;
   private String remarks;
}
