package se.iths.autofix.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String part;
    private String category;
    @DecimalMin(value = "0.0")
    private double price;
    @Positive
    private int quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sparepart_client")
    private Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sparepart_employee")
    private Employee employee;

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
    public SparePart(String category, @NotEmpty String part, double price, int quantity) {
        this.category = category;
        this.part = part;
        this.price = price;
        this.quantity = quantity;
    }

    public SparePart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
