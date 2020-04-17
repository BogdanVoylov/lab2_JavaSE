package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;
import org.w3c.dom.events.Event;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;

public class CardView extends javax.swing.JPanel {

    public CardView(Group group) throws IOException {
        initComponents(group);
    }

    private void initComponents(Group group) throws IOException {
        //uncomment this when finished testing
//        BufferedImage myPicture = ImageIO.read(new File(group.getPhotoLink()));
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
        System.out.println("deb: name:"+group.getName());

        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jTextField1.getText().equals(group.getName())) {
                    int reply = JOptionPane.showConfirmDialog(null, "Do you want to rename a group", "Change confirmation", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        group.setName(jTextField1.getText());
                        try {
                            MultipleGroupsReaderWriter.overwriteGroups(new File(Main.filepath), Main.groups);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Error occurred while saving a file*");
                        }
                    }
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.

                setLayout(layout);
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
    }

    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField jTextField1;
}