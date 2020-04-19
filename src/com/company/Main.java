package com.company;

import java.io.IOException;
import java.util.ArrayList;
import com.company.model.Group;
import com.company.view.MainFrame;
import javax.swing.*;


public class Main {

    public static MainFrame mainFrame;
    public static String filepath;
    public static ArrayList<Group> groups;
    public static void main(String[] args) throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.setSize(800,600);
    }
}
