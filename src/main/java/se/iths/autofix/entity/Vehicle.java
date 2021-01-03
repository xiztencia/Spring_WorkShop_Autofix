package se.iths.autofix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String numberPlate;
    private String maker;
    private String model;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_client")
    private Client client;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_employee")
    private Employee employee;

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle(@NotEmpty String numberPlate, String maker, String model) {
        this.numberPlate = numberPlate;
        this.maker = maker;
        this.model = model;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
