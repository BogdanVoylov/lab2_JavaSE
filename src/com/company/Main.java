package com.company;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;
import com.company.view.MainFrame;
import com.company.view.ObjectsPannel;

import javax.imageio.ImageIO;

public class Main {

    public static MainFrame mainFrame;
    public static String filepath;
    public static ArrayList<Group> groups;
    public static void main(String[] args) throws IOException {
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
