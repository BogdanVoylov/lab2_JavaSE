package com.company.model;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Group implements Serializable {
    private static final long serialVersionUID = -2772406316807560219L;
    private String name;
    private HashSet<Product> products;
    private BufferedImageWrapper image;

    public Group(String name, BufferedImage image) {
        this.name = name;
        products = new HashSet<Product>();
        this.image = new BufferedImageWrapper(image);
    }

    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image.getImage();
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setImage(BufferedImage bufferedImage) {
        image.setImage(bufferedImage);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ISetModifier<Product> getProductsModifier() {
        return new ProductsModifier();
    }

    public Iterator<Product> getIterator() {
        return products.iterator();
    }

    public IStatisticsProvider getStatisticsProvider() {
        return new StatisticsProvider();
    }

    public IProductSearcher getProductSearcher() {
        return new Searcher();
    }


    private class ProductsModifier implements ISetModifier<Product> {

        @Override
        public void add(Product product) {
            products.add(product);
        }

        @Override
        public void remove(String name) {
            try {
                products.remove(new Product(name, "", 0, 0));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void edit(String name, Product newProduct) {
            remove(name);
            products.add(newProduct);
        }
    }

    private class StatisticsProvider implements IStatisticsProvider {
        @Override
        public int getGeneralPriceOfGroup() {
            int res = 0;
            for (Product product : products) {
                res += product.getWholePrice();
            }
            return res;
        }
    }


    private class Searcher implements IProductSearcher {

        @Override
        public List<Product> searchByName(String name) {
            return products.stream().filter(product -> product.getName().contains(name)).collect(Collectors.toList());
        }

        @Override
        public List<Product> filterByPrice(int begin, int end) {
            return products.stream().filter(product -> product.getPrice() >= begin && product.getPrice() <= end).collect(Collectors.toList());
        }

        @Override
        public List<Product> filterByQuantity(int begin, int end) {
            return products.stream().filter(product -> product.getCount() >= begin && product.getCount() <= end).collect(Collectors.toList());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
