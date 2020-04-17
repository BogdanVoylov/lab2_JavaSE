package com.company;

import com.company.model.Group;
import com.company.model.MultipleGroupsReaderWriter;
import com.company.model.Product;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<Group> groupList = new ArrayList<>();
        Group group = new Group("fruits", ImageIO.read(new File("static\\fruit.jpg")));
        group.getProductsModifier().add(new Product("apple","",10,10));
        groupList.add(group);
        MultipleGroupsReaderWriter.overwriteGroups(new File("static\\test.dat"),groupList);
        groupList = MultipleGroupsReaderWriter.readGroups(new File("static\\test.dat"));
        System.out.println("kk");
    }
}
