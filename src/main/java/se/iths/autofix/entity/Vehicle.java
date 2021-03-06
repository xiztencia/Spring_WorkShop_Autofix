package se.iths.autofix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client vehicle_client;

    public Vehicle(@NotEmpty String numberPlate, String maker, String model) {
        this.numberPlate = numberPlate;
        this.maker = maker;
        this.model = model;
    }

    public Vehicle(@NotEmpty String numberPlate, String maker, String model, Client client) {
        this.numberPlate = numberPlate;
        this.maker = maker;
        this.model = model;
        this.vehicle_client = client;
    }

    public Vehicle() {
    }

    public void setClient(Client client) {
        this.vehicle_client = client;
    }

    public void setVehicle_client(Client client) {
        this.vehicle_client = client;
    }

    public Client getVehicle_client() {
        return vehicle_client;
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


}
