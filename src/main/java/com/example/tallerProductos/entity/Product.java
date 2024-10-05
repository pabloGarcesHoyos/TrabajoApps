package com.example.tallerProductos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sku")
    private long sku;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "brand")
    private String brand;

    @Column(name = "store")
    private String store;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<User> users;

    public Product() {
        super();
    }

    public Product(long id, long sku, String name, String price, String brand, String store) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.store = store;
    }

    public Product(long sku, String name, String price, String brand, String store) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.store = store;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public List<User> getUsers() {
        return users;
    }
}
