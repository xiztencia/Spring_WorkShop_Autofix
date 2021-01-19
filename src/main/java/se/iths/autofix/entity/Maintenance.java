package se.iths.autofix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@NotEmpty
    private String type;
    private double price;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date checkInDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date checkOutDate;
    private String jobHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client mainten_client;

    public void setClient(Client client) {
        this.mainten_client = client;
    }

    public Maintenance(@NotEmpty String type, double price, Date checkInDate, Date checkOutDate) {
        this.type = type;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    public Maintenance(@NotEmpty String type, double price, Date checkInDate, Date checkOutDate,Client client) {
        this.type = type;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.mainten_client=client;
    }
    public Maintenance(@NotEmpty Long id,@NotEmpty String type, double price, Date checkInDate, Date checkOutDate, String jobHistory) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.jobHistory = jobHistory + "\n";
    }

    public Maintenance() {
    }

    public Client getMainten_client() {
        return mainten_client;
    }

    public void setMainten_client(Client mainten_client) {
        this.mainten_client = mainten_client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobHistory() {
        return jobHistory;
    }

    public void setJobHistory(String jobHistory) {
        this.jobHistory = jobHistory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }


}
