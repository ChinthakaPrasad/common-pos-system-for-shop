package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Order> orders = new ArrayList<>();
}
