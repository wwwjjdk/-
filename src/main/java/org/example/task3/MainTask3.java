package org.example.task3;

import com.google.gson.Gson;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainTask3 {
    public static Gson gson = new Gson();

    public static void main(String[] args) {

        generateNewJsonFile(Paths.get("src/main/java/org/example/task3", "tests.json").toString(),
                Paths.get("src/main/java/org/example/task3","values.json").toString(),
                Paths.get("src/main/java/org/example/task3","report.json").toString());
    }

    private static void generateNewJsonFile(String pathForModel, String pathForUpdate, String pathForNewFileWithUpdate) {
        try (
                FileReader fileReader = new FileReader(pathForModel);
        ) {
            Tests tests = gson.fromJson(fileReader, Tests.class);

            updateValues(tests.getTests(), pathForUpdate);

            Files.write(Paths.get(pathForNewFileWithUpdate), gson.toJson(tests).getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateValues(List<Test> tests, String path) {
        try (
                FileReader fileReader = new FileReader(path);
        ) {
            Values values = gson.fromJson(fileReader, Values.class);
            for (Test test : tests) {
                for (Value value : values.getValues()) {
                    if (test.getId() == value.getId()) {
                        test.setValue(value.getValue());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
