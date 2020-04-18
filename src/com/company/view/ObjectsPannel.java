package com.company.view;

import com.company.Main;
import com.company.model.Group;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ObjectsPannel extends JPanel {

    public ObjectsPannel(ArrayList<Group> groups) throws IOException {
        initComponents(groups);
    }

    private void initComponents(ArrayList<Group> groups) throws IOException {
        this.setLayout(new CardLayout());
        this.setPreferredSize(new Dimension(800,600));
        setBackground(new java.awt.Color(255, 102, 102));
        JPanel container = new ScrollablePanel(groups.size(), 220,170, 20 ,20);
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        groups.sort(Comparator.comparing(Group::getName));
        for (Group group : groups) {
            CardView cv = new CardView(group);
            container.add(cv);
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
    }

    static void reloadObjectPanel(ArrayList<Group> groups){
        ObjectsPannel kk = null;
        try {
            kk = new ObjectsPannel(groups);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Main.mainFrame.setContentPane(kk);
        Main.mainFrame.revalidate();
        Main.mainFrame.repaint();
    }
}




