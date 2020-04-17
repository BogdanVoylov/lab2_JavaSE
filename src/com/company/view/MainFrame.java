package com.company.view;

import com.company.model.Group;

import javax.swing.*;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public MainFrame() throws IOException {
        initComponents();
    }


    private void initComponents() throws IOException {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        this.setLayout(new FlowLayout());
        jMenuBar1.setBorder(null);
        jMenuBar1.setMinimumSize(new java.awt.Dimension(64, 30));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(64, 30));

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setText("Open file");
        jMenu1.addMenuListener(new CustomMenuListener());
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu2.setText("Create file");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        revalidate();
        repaint();
    }

    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    JPanel kk1;
}
