package com.company.view.TableClasses;

import com.company.Main;
import com.company.model.Product;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EditableTableModel extends AbstractTableModel {

    private ArrayList<Product> products;
    private static HashSet<Product> updatedHashSet;
    private final String[] columnsName = new String[]{"Name", "Description", "Quantity", "Price", "IsStock"};
    private final Class[] columnsClass = new Class[]{String.class, String.class, Integer.class, Integer.class, Boolean.class};

    public EditableTableModel(HashSet<Product> products) {
        this.products = new ArrayList<Product>();
        this.products.addAll(products);
        updatedHashSet = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return columnsName.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnsName[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnsClass[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getName();
            case 1:
                return product.getDescription();
            case 2:
                return product.getCount();
            case 3:
                return product.getPrice();
            case 4:
                return product.getCount() > 0;
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                product.setName((String) aValue);
                return;
            case 1:
                product.setDescription((String) aValue);
                return;
            case 2:
                product.setCount((Integer) aValue);
                return;
            case 3:
                product.setPrice((Integer) aValue);
            case 4:
        }
    }

    public void removeRows(int[] indexes) {
        for (int i = 0; i < indexes.length; i++) {
            Product neededRow = products.get(indexes[i] - i);
            updatedHashSet.remove(neededRow);
            products.remove(neededRow);
        }
    }

    public void addProduct(String name, String description, int price, int count) throws Exception {
        Product product = new Product(name, description, price, count);
        products.add(product);
        updatedHashSet.add(product);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    static HashSet<Product> getUpdatedHashSet() {
        return updatedHashSet;
    }


}
