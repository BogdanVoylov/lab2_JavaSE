package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        class CreateCategoryCard {
            JButton choosePhotoButton;
            JTextField nameField;
            JLabel nameLabel;
            JPanel panel;
            File photo;

            private void getPanel() {
                JButton choosePhotoButton;
                JTextField nameField;
                JLabel nameLabel;
                JPanel panel = new JPanel();
                photo = new File("static/notfound.jpg");

                nameLabel = new javax.swing.JLabel();
                nameField = new javax.swing.JTextField();
                choosePhotoButton = new javax.swing.JButton();

                panel.setBackground(new java.awt.Color(204, 204, 204));
                panel.setPreferredSize(new java.awt.Dimension(220, 170));

                nameLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                nameLabel.setText("Name:");

                choosePhotoButton.setFont(new java.awt.Font("Arial", 1, 12));
                choosePhotoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                        int returnValue = jfc.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            photo = jfc.getSelectedFile();
                        }
                    }
                });
                choosePhotoButton.setText("Choose photo");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
                panel.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(choosePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(20, 20, 20))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(choosePhotoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                        .addContainerGap(35, Short.MAX_VALUE))
                );
                this.panel = panel;
                this.nameField = nameField;
            }

        }
        CreateCategoryCard categoryCard = new CreateCategoryCard();
        categoryCard.getPanel();
        UIManager.put("OptionPane.minimumSize", new Dimension(420, 170));
        int result = JOptionPane.showConfirmDialog(null, categoryCard.panel,
                "Adding a category", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                boolean found = false;
                for (Group g : Main.groups)
                    if (g.getName().equals(categoryCard.nameField.getText())) found = true;

                if (!found && !categoryCard.nameField.getName().matches("\\s*")) {
                    Group group = new Group(categoryCard.nameField.getText(), ImageIO.read(categoryCard.photo));
                    List<Group> l = new ArrayList<Group>();
                    l.add(group);
                    MultipleGroupsReaderWriter.appendGroups(new File(Main.filepath), l);
                    Main.groups = (ArrayList<Group>) MultipleGroupsReaderWriter.readGroups(new File(Main.filepath));
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong name specified", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            ObjectsPannel.reloadObjectPanel(Main.groups);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
