package se.iths.autofix.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   // private String type;
    private int quantity;
    private double totalPrice;

    @OneToMany(mappedBy = "shoppingcart_sales")
    private List<Sale> addedItemsOnCart;

    public ShoppingCart(){

    }

    public ShoppingCart( int quantity, double totalPrice) {
      //  this.type = type;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
