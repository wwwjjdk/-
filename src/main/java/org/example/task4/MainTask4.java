package org.example.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTask4 {
    public static void main(String[] args) {
        String name = "numbers.txt";
        var path = Paths.get("src/main/java/org/example/task4", name);

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(path)))

        ) {
            List<Integer> list = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

            searchMinTime(list.toArray(Integer[]::new));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int searchMedian(Integer[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        } else {
            return array[array.length / 2];
        }
    }

    private static void searchMinTime(Integer[] array) {
        int steps = 0;
        int targetSearch = searchMedian(array);
        for (int num : array) {
            steps += Math.abs(num - targetSearch);
        }
        System.out.println(steps);
    }

}
