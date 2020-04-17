package com.company.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MultipleGroupsReaderWriter {
    public static List<Group> readGroups(File file) throws IOException, ClassNotFoundException {
        return (List<Group>) new ObjectInputStream(new FileInputStream(file)).readObject();
    }

    public static void overwriteGroups(File file, List<Group> groups) throws IOException {
        new ObjectOutputStream(new FileOutputStream(file)).writeObject(groups);
    }

    public static void appendGroups(File file, List<Group> groups) throws IOException, ClassNotFoundException {
        List<Group> existing = readGroups(file);
        existing.addAll(groups);
        overwriteGroups(file, existing);
    }
}
