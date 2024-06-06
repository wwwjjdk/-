package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class MainTask2 {
    public static void main(String[] args) {
        String pathFile1 = Paths.get("src/main/java/org/example/task2", "file1.txt").toString();
        String pathFile2 = Paths.get("src/main/java/org/example/task2", "file2.txt").toString();
        searchPositionOfThePoint(pathFile1,pathFile2);
    }
    private static void searchPositionOfThePoint(String path1, String path2){
        try (
                BufferedReader circleReader = new BufferedReader(
                        new FileReader(path1));
                BufferedReader pointsReader = new BufferedReader(
                        new FileReader(path2))
        ) {
            String[] circleLine = circleReader.readLine().split(" ");
            double centerX = Double.parseDouble(circleLine[0]);
            double centerY = Double.parseDouble(circleLine[1]);
            double radius = Double.parseDouble(circleReader.readLine());

            String line;
            while ((line = pointsReader.readLine()) != null) {
                String[] pointCoords = line.split(" ");
                double pointX = Double.parseDouble(pointCoords[0]);
                double pointY = Double.parseDouble(pointCoords[1]);

                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));

                if (distance == radius) {
                    System.out.println("0");
                } else if (distance < radius) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
