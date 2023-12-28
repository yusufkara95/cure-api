package de.yusufkara.cureapi.model;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;

    public Job() {};

    public Job(String name, int price, Customer customer) {
        super();
        this.name = name;
        this.price = price;
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    // Getter  and  setter
    public Customer getCustomer()  {
        return customer;
    }

    public void setCustomer(Customer customer)  {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
