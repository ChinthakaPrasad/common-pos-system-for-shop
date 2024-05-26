package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "Customer")
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int customerId;
   private String customerName;
   private String phoneNumber;
   private String nic;
   private String remarks;

   public Customer(String customerName, String phoneNumber, String nic, String remarks, List<Order> orders) {
      this.customerName = customerName;
      this.phoneNumber = phoneNumber;
      this.nic = nic;
      this.remarks = remarks;
      this.orders = orders;
   }

   @OneToMany
   @JoinColumn(name = "customerId")
   private List<Order> orders;
}
