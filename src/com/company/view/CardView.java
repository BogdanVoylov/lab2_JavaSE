package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.view.TableClasses.Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CardView extends javax.swing.JPanel {

    public CardView(Group group) throws IOException {
        initComponents(group);
    }

    private void initComponents(Group group) throws IOException {
        BufferedImage myPicture = group.getImage();
        imageLabel = new javax.swing.JLabel(new ImageIcon(myPicture));
        jTextField1 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(220, 170));
        setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setText(group.getName());
        jTextField1.setBorder(null);

        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField1.getText().equals(group.getName())) {
                    int reply = JOptionPane.showConfirmDialog(null, "Do you want to rename a group", "Change confirmation", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        for (Group g : Main.groups) {
                            if (g.getName().equals(jTextField1.getText())) {
                                JOptionPane.showMessageDialog(null, "You can`t specify existing category`s name", "Error", JOptionPane.ERROR_MESSAGE);
                                jTextField1.setText(group.getName());
                                break;
                            }
                        }
                        if (jTextField1.getText().matches("\\s*")) {
                            JOptionPane.showMessageDialog(null, "You can`t specify an empty name", "Error", JOptionPane.ERROR_MESSAGE);
                            jTextField1.setText(group.getName());
                        }
                        group.setName(jTextField1.getText());
                        try {
                            MultipleGroupsReaderWriter.overwriteGroups(new File(Main.filepath), Main.groups);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error occurred while saving a file*");
                        }
                    } else {
                        jTextField1.setText(group.getName());
                    }
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    UIManager.put("OptionPane.minimumSize", new Dimension(100, 100));
                    int reply = JOptionPane.showConfirmDialog(null, "Do you want to delete a group", "Delete confirmation", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        Main.groups.remove(group);
                        try {
                            MultipleGroupsReaderWriter.overwriteGroups(new File(Main.filepath), Main.groups);
                            ObjectsPannel.reloadObjectPanel(Main.groups);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error occurred while saving a file");
                        }
                    }
                } else {
                    Form form = null;
                    try {
                        form = new Form(group.getName(), 600, 600, group);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    assert form != null;
                    form.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField jTextField1;
}