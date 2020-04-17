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
        for (int i = 0; i < 20; i++) {
            Group group = new Group("1", ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\grechka.jpg")));
            group.getProductsModifier().add(new Product("apple", "", 10, 10));
            groupList.add(group);
        }
        MultipleGroupsReaderWriter.overwriteGroups(new File("static\\test.dat"), groupList);
        groupList = MultipleGroupsReaderWriter.readGroups(new File("static\\test.dat"));
        for(Group gr: groupList){
            System.out.println(gr.getImage());
            System.out.println(gr.getName());
        }
    }
}
