package se.iths.autofix.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "vehicle_client", fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "mainten_client", fetch = FetchType.LAZY)
    private Set<Maintenance> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "spare_client", fetch = FetchType.LAZY)
    private Set<SparePart> spareParts = new HashSet<>();

    public Client(@NotEmpty String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public Client(@NotEmpty String username, String firstname, String lastname, String email, String password, Vehicle vehicles) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.vehicles.add(vehicles);
    }

    public Client() {
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setClient(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.setClient(null);
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addMaintenance(Maintenance maintenance) {
        maintenances.add(maintenance);
        maintenance.setClient(this);
    }

    public void removeMaintenance(Maintenance maintenance) {
        maintenances.remove(maintenance);
        maintenance.setClient(null);
    }

    public Set<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void addSparePart(SparePart sparePart) {
        spareParts.add(sparePart);
        sparePart.setSpare_client(this);
    }

    public void removeSparePart(SparePart sparePart) {
        spareParts.remove(sparePart);
        sparePart.setSpare_client(null);
    }

    public Set<SparePart> getSpareParts() {
        return spareParts;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
