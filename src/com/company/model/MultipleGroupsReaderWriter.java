package com.company.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultipleGroupsReader {
    public List<Group> readGroups(File file) throws FileNotFoundException {
        List<Group> res = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
                res.add((Group) objectInputStream.readObject());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
