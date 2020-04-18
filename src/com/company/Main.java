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
//        List<Group> groupArray = new ArrayList<Group>();
//        for(int i = 0; i<20; i++){
//            groupArray.add(new Group("Vasya", ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\grechka.jpg"))));
//        }
//        MultipleGroupsReaderWriter.overwriteGroups(new File("C:\\Users\\Lenovo\\Desktop\\test.dat"), groupArray);
    }
}
