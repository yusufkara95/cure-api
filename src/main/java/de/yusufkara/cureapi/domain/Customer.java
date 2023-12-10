package de.yusufkara.cureapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName, lastName;

    public Customer() {};

    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
    private List<Job> jobs;

    public List<Job> getJobs()  {
        return jobs;
    }

    public void setJobs(List<Job> jobs)  {
        this.jobs = jobs;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
