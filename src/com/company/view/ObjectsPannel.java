package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ObjectsPannel extends JPanel {

    public ObjectsPannel(Article[] articles) throws IOException {
        initComponents(articles);
    }

    private void initComponents(Article[] articles) throws IOException {
        this.setLayout(new CardLayout());
        this.setPreferredSize(new Dimension(800,600));
        setBackground(new java.awt.Color(255, 102, 102));
        JPanel container = new ScrollablePanel(articles.length, 220,170, 10,10);
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        for (int i = 0; i < articles.length; i++) {
            CardView cv = new CardView(articles[i]);
            container.add(cv);
        }

        JScrollPane scroll = new JScrollPane(container);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
    }
}




