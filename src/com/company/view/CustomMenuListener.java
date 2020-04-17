package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            List<Group> groups = new ArrayList<Group>();
            String filepath = "";
            try {
                groups = MultipleGroupsReaderWriter.readGroups(jfc.getSelectedFile());
                Main.groups = (ArrayList<Group>) groups;
                System.out.println(groups);
                filepath = jfc.getSelectedFile().getAbsolutePath();
                Main.filepath = filepath;
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid file");
                return;
            }
            ObjectsPannel kk1 = null;
            //works on custom data i suppose that mistake is in data
            try {
                kk1 = new ObjectsPannel((ArrayList<Group>) groups);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Main.mainFrame.add(kk1);
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
