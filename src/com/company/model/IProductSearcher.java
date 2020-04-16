package com.company.model;

import java.util.List;

public interface IProductSearcher {
    List<Product> searchByName(String name);
    List<Product> filterByPrice(int begin, int end);
    List<Product> filterByQuantity(int begin, int end);
}
