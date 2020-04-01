package model;

public class Product {
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int price;
    private int count;
    public Product(String name, int price, int count) throws Exception {
        this.name = name;
        if(count < 0 || price < 0){
            throw new Exception();
        }
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
