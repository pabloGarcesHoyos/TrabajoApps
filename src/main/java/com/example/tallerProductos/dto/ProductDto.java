package com.example.tallerProductos.dto;

public class ProductDto {


    private long Sku;
    private String name;
    private double price;
    private String brand;
    private String store;

    public long getSku() {
        return Sku;
    }

    public void setSku(long sku) {
        Sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
}
