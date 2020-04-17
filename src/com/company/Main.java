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
        List<Group> groupArray = new ArrayList<Group>();
        for(int i = 0; i<20; i++){
            groupArray.add(new Group("Vasya", ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\test.dat"))));
        }
        MultipleGroupsReaderWriter.overwriteGroups(new File("C:\\Users\\Lenovo\\Desktop\\test.dat"), groupArray);
//        ArrayList<Group> ar = new ArrayList<Group>();
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ar.add(new Group("Dima", "C:\\Users\\Lenovo\\Desktop\\grechka.jpg"));
//        ObjectsPannel op = new ObjectsPannel(ar);
//        mainFrame.add(op);
//        mainFrame.revalidate();
//        mainFrame.repaint();


//        Group group = new Group("fruits");
//        ISetModifier<Product> modifier = group.getProductsModifier();
//        try {
//            modifier.add(new Product("apple","good apple",0,0));
//            for (Iterator<Product> it = group.getIterator(); it.hasNext(); ) {
//                Product product = it.next();
//                System.out.println(product.getName());
//            }
//            List<Group> groups = new ArrayList<>();
//            groups.add(group);
//            MultipleGroupsReaderWriter.appendGroups(new File("test.dat"), groups);
//            groups = MultipleGroupsReaderWriter.readGroups(new File("test.dat"));
//            System.out.println("kek");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
