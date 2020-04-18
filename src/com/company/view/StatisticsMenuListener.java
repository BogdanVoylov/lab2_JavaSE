package com.company.view;

import com.company.Main;
import com.company.model.Group;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class StatisticsMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        class StatisticsCard {
            private javax.swing.JScrollPane jScrollPane1;
            private javax.swing.JLabel storagePriceLabel;
            private javax.swing.JTextArea textAreaforGroups;
            private javax.swing.JLabel totalLabelNotFunctional;
            private JPanel panel;

            StatisticsCard() {

                totalLabelNotFunctional = new javax.swing.JLabel();
                storagePriceLabel = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                textAreaforGroups = new javax.swing.JTextArea();
                panel = new JPanel();

                panel.setBackground(new java.awt.Color(204, 204, 204));
                panel.setPreferredSize(new java.awt.Dimension(220, 170));

                totalLabelNotFunctional.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
                totalLabelNotFunctional.setText("Total storage price:");

                storagePriceLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

                textAreaforGroups.setColumns(20);
                textAreaforGroups.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
                textAreaforGroups.setRows(5);
                jScrollPane1.setViewportView(textAreaforGroups);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
                panel.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(totalLabelNotFunctional, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(storagePriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(47, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(storagePriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totalLabelNotFunctional, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(27, Short.MAX_VALUE))
                );
            }
        }

        StatisticsCard card = new StatisticsCard();
        String totalRes = "";
        int res = 0;
        for (Group g : Main.groups) {
            res += g.getStatisticsProvider().getGeneralPriceOfGroup();
            totalRes += g.getName() + " - " + g.getStatisticsProvider().getGeneralPriceOfGroup() + "\n";
        }
        card.storagePriceLabel.setText(String.valueOf(res));
        card.textAreaforGroups.setText(totalRes);
        UIManager.put("OptionPane.minimumSize", new Dimension(600, 410));
        JOptionPane.showMessageDialog(null, card.panel, "Statistics", JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
