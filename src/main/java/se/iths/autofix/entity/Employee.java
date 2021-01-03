package se.iths.autofix.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String username;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Maintenance> maintenances = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SparePart> spareParts = new HashSet<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        vehicle.setEmployee(this);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
        vehicle.setEmployee(null);
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addMaintenance(Maintenance maintenance) {
        maintenances.add(maintenance);
        maintenance.setEmployee(this);
    }

    public void removeMaintenance(Maintenance maintenance) {
        maintenances.remove(maintenance);
        maintenance.setEmployee(null);
    }

    public Set<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void addSparePart(SparePart sparePart) {
        spareParts.add(sparePart);
        sparePart.setEmployee(this);
    }

    public void removeSparePart(SparePart sparePart) {
        spareParts.remove(sparePart);
        sparePart.setEmployee(null);
    }

    public Set<SparePart> getSpareParts() {
        return spareParts;
    }
//    public enum range {
//        ADMIN, USER
//    }

    public Employee(@NotEmpty String username, String lastname, String firstname, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Employee() {
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
