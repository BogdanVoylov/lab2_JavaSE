package com.company.view;

import com.company.Main;
import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewFileMenuListener implements MenuListener {
    @Override
    public void menuSelected(MenuEvent e) {

        ArrayList<Group> groups = new ArrayList<Group>();
        String filepath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                JOptionPane.showInputDialog("Input your database name")).getAbsolutePath();
        Main.groups = groups;
        Main.filepath = filepath;


    }


    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
