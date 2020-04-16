package com.company.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultipleGroupSearcher {
    List<Product> searchByName(String name, Collection<Group> groups){
        List<Product> res = new ArrayList<>();
        for (Group group:groups){
            IProductSearcher productSearcher = group.getProductSearcher();
            res.addAll(productSearcher.searchByName(name));
        }
        return res;
    }
}