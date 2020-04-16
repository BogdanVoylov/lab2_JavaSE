package com.company.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int price;
    private int count;
    public Product(String name, String description, int price, int count) throws Exception {
        if(count < 0 || price < 0){
            throw new Exception();
        }
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
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

    public int getWholePrice(){
        return price*count;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
