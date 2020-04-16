package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.company.model.Group;
import com.company.model.ISetModifier;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;

public class Main {
    public static void main(String[] args) throws IOException {
        /*MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(800,600);*/
        Group group = new Group("fruits");
        ISetModifier<Product> modifier = group.getProductsModifier();
        try {
            modifier.add(new Product("apple","good apple",0,0));
            for (Iterator<Product> it = group.getIterator(); it.hasNext(); ) {
                Product product = it.next();
                System.out.println(product.getName());
            }
            List<Group> groups = new ArrayList<>();
            groups.add(group);
            MultipleGroupsReaderWriter.appendGroups(new File("test.dat"), groups);
            groups = MultipleGroupsReaderWriter.readGroups(new File("test.dat"));
            System.out.println("kek");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
