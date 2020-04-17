package com.company.view;

import com.company.model.Group;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

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
        for (Group group : groups) {
            CardView cv = new CardView(group);
            container.add(cv);
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
    }
}




