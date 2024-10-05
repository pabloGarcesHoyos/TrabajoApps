package com.example.tallerProductos.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "adress")
    private String adress;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public User() {
        super();
    }

    public User(long id, String name, String lastName, String adress, String password, String username, Product product) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.password = password;
        this.username = username;
        this.product = product;
    }

    public User(String name, String lastName, String adress, String password, String username, Product product) {
        this.name = name;
        this.lastName = lastName;
        this.adress = adress;
        this.password = password;
        this.username = username;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
