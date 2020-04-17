package com.company.view;

import com.company.Main;
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
        jMenu3 = new JMenu();


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
        jMenu2.addMenuListener(new NewFileMenuListener());
        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(BorderFactory.createEtchedBorder());
        jMenu3.setText("Add category");
        jMenu3.addMenuListener(new CategoryMenuListener());
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);
        setJMenuBar(jMenuBar1);
        JPanel panel = new JPanel();
        panel.add(new JLabel("Choose existing or create new database"));
        setContentPane(panel);
        revalidate();
        repaint();
    }

    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    static JMenu jMenu3;
}
