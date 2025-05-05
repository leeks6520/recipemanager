package utils;

import models.Recipe;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void saveToFile(List<Recipe> data, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(data);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Recipe> loadFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Recipe>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new java.util.ArrayList<>();
        }
    }
}
