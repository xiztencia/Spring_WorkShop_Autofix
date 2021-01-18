package se.iths.autofix.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Positive
    private int quantity;
    @DecimalMin(value = "0.0")
    private double totalPrice;


    @OneToOne
    private Maintenance maintenance;
    @OneToOne
    private SparePart sparePart;

    public ShoppingCart() {
    }

    public ShoppingCart(int quantity, double totalPrice) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



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
