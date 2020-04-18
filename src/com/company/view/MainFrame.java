package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public MainFrame() throws IOException {
        initComponents();
    }


    private void initComponents() throws IOException {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        jMenu5 = new JMenu();


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

        jMenu4.setBorder(BorderFactory.createEtchedBorder());
        jMenu4.setText("Write off");
        jMenu4.addMenuListener(new WriteOffMenuListener());
        jMenu4.setEnabled(false);
        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(BorderFactory.createEtchedBorder());
        jMenu5.setText("Statistics");
        jMenu5.addMenuListener(new StatisticsMenuListener());
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

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
    static JMenu jMenu4;
    static JMenu jMenu5;
}
