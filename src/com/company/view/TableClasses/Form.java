package com.company.view.TableClasses;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

import static java.awt.event.KeyEvent.VK_BACK_SPACE;

public class Form extends JFrame {
    private JPanel MainPanel;
    private JButton addBtn;
    private JButton removeBtn;
    private JButton saveButton;
    private JTable table;

    class AddCard {
        JPanel panel;
        JLabel nameLabel;
        JTextField nameField;
        JLabel descriptionLabel;
        JLabel priceLabel;
        JTextField quantityField;
        JLabel quantityLabel;
        JScrollPane jScrollPane1;
        JTextArea descriptionField;
        JTextField priceField;

        void getCard() {
            panel = new JPanel();
            nameLabel = new JLabel();
            nameField = new JTextField();
            descriptionLabel = new JLabel();
            priceLabel = new JLabel();
            quantityField = new JTextField();
            quantityLabel = new JLabel();
            jScrollPane1 = new JScrollPane();
            descriptionField = new JTextArea();
            priceField = new JTextField();

            panel.setBackground(new java.awt.Color(204, 204, 204));
            panel.setPreferredSize(new java.awt.Dimension(220, 170));

            nameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            nameLabel.setText("Name:");

            descriptionLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            descriptionLabel.setText("Description:");

            priceLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            priceLabel.setText("Price:");

            quantityLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
            quantityLabel.setText("Quantity:");

            descriptionField.setColumns(20);
            descriptionField.setRows(5);
            jScrollPane1.setViewportView(descriptionField);

            priceField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == VK_BACK_SPACE) {
                        priceField.setEditable(true);
                    } else {
                        priceField.setEditable(false);
                    }
                }
            });

            quantityField.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent ke) {
                    if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == VK_BACK_SPACE) {
                        quantityField.setEditable(true);
                    } else {
                        quantityField.setEditable(false);
                    }
                }
            });


            GroupLayout layout = new GroupLayout(panel);
            panel.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(21, 21, 21))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(nameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(descriptionLabel)
                                            .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(13, 13, 13)
                                                    .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(25, Short.MAX_VALUE))
            );
        }
    }

    public Form(String title, int WIN_WIDTH, int WIN_HEIGHT, Group group) throws Exception {
        super(title);
        HashSet<Product> products = group.getProducts();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = ((int) screenSize.getWidth() - WIN_WIDTH) / 2;
        int locationY = ((int) screenSize.getHeight() - WIN_HEIGHT) / 2;
        this.setSize(WIN_WIDTH, WIN_HEIGHT);
        this.setLocation(locationX, locationY);
        this.setContentPane(MainPanel);

        initComponents(products);
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditableTableModel model = (EditableTableModel) (table.getModel());
                model.removeRows(table.getSelectedRows());
                table.revalidate();
                table.clearSelection();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    group.setProducts(EditableTableModel.getUpdatedHashSet());
                    MultipleGroupsReaderWriter.overwriteGroups(new File(Main.filepath), Main.groups);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EditableTableModel model = (EditableTableModel) (table.getModel());
                AddCard cardObj = new AddCard();
                cardObj.getCard();
                UIManager.put("OptionPane.minimumSize", new Dimension(500, 350));
                int result = JOptionPane.showConfirmDialog(null, cardObj.panel,
                        "Adding a product", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    try {
                        model.addProduct(cardObj.nameField.getText(), cardObj.descriptionField.getText(), Integer.parseInt(cardObj.priceField.getText()), Integer.parseInt(cardObj.quantityField.getText()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                table.revalidate();
            }
        });
    }

    private void initComponents(HashSet<Product> products) throws Exception {
        Random rnd = new Random();
        table = new JTable(new EditableTableModel(products));
        table.setSelectionBackground(new Color(250, 120, 148, 50));
        JScrollPane scrollPane = new JScrollPane(table);
        MainPanel.add(scrollPane);

    }

}




