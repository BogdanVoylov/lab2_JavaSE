package com.company.view;

import com.company.Main;
import com.company.model.Group;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.io.File;
import java.util.ArrayList;


public class NewFileMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        ArrayList<Group> groups = new ArrayList<Group>();
        String answer = JOptionPane.showInputDialog("Input your database name");
        if (answer != null) {
            String filepath = new File(answer + ".dat").getAbsolutePath();
            Main.groups = groups;
            Main.filepath = filepath;
            JPanel panel = new JPanel();
            panel.add(new JLabel("Database created, now you can add a category"));
            Main.mainFrame.setContentPane(panel);
            MainFrame.jMenu3.setEnabled(true);
            MainFrame.jMenu4.setEnabled(true);
            MainFrame.jMenu5.setEnabled(true);
            Main.mainFrame.revalidate();
            Main.mainFrame.repaint();
        }
    }


    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
