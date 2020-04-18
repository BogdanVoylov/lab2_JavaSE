package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import static java.awt.event.KeyEvent.VK_BACK_SPACE;

public class WriteOffMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        class WriteOffCard {
            private JComboBox categoryPicker;
            private javax.swing.JLabel chooseCategoryLabel;
            private JComboBox productPicker;
            private javax.swing.JTextField quantityField;
            private javax.swing.JLabel quantityLabel;
            private JPanel panel;


            private void initComponents(ArrayList<Group> groups) {

                quantityField = new JTextField();
                quantityField.setEnabled(false);
                quantityField.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {
                        if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == VK_BACK_SPACE) {
                            quantityField.setEditable(true);
                        } else {
                            quantityField.setEditable(false);
                        }
                    }
                });
                quantityLabel = new JLabel();
                productPicker = new JComboBox();
                Group[] groupsArray = new Group[groups.size()];
                for (int i = 0; i < groups.size(); i++) {
                    groupsArray[i] = groups.get(i);
                }
                categoryPicker = new JComboBox(groupsArray);
                categoryPicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        productPicker.setEnabled(true);
                        Group group = (Group) categoryPicker.getSelectedItem();
                        assert group != null;
                        ArrayList<Product> products = new ArrayList<Product>(group.getProducts());
                        Product[] productsArray = new Product[products.size()];
                        for (int i = 0; i < products.size(); i++) {
                            productsArray[i] = products.get(i);
                        }
                        productPicker.setModel(new DefaultComboBoxModel(productsArray));
                    }
                });
                productPicker.setEditable(true);
                productPicker.setEnabled(false);
                AutoCompletion.enable(productPicker);
                productPicker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        quantityField.setEnabled(true);
                    }
                });
                chooseCategoryLabel = new JLabel();
                panel = new JPanel();

                panel.setBackground(new java.awt.Color(204, 204, 204));
                panel.setPreferredSize(new java.awt.Dimension(220, 170));

                quantityLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                quantityLabel.setText("Quantity:");

                categoryPicker.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N


                chooseCategoryLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                chooseCategoryLabel.setText("Choose category:");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
                panel.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(chooseCategoryLabel)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(productPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(categoryPicker, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(chooseCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(categoryPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(quantityField)
                                                .addComponent(productPicker, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                                        .addContainerGap(190, Short.MAX_VALUE))
                );

            }
        }
        WriteOffCard card = new WriteOffCard();
        card.initComponents(Main.groups);
        UIManager.put("OptionPane.minimumSize", new Dimension(700, 300));
        int result = JOptionPane.showConfirmDialog(null, card.panel,
                "Writing off a product", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            if (!card.quantityField.getText().equals("")) {
                if (card.categoryPicker.getSelectedItem() != null) {
                    if (card.productPicker.getSelectedItem() != null) {
                        Product chosenProduct = (Product) card.productPicker.getSelectedItem();
                        int quantity = Integer.parseInt(card.quantityField.getText());
                        Group chosenGroup = (Group) card.categoryPicker.getSelectedItem();
                        boolean found = false;
                        for (Group g : Main.groups) {
                            if (g.getName().equals(chosenGroup.getName())) {
                                Main.groups.remove(g);
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            for (Product p : chosenGroup.getProducts()) {
                                if (p.getName().equals(chosenProduct.getName())) {
                                    int res = p.getCount() - quantity;
                                    if (res < 0) res = 0;
                                    p.setCount(res);
                                    Main.groups.add(chosenGroup);
                                    try {
                                        MultipleGroupsReaderWriter.overwriteGroups(new File(Main.filepath), Main.groups);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
