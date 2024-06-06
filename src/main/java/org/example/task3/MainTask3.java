package org.example.task3;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainTask3 {
    public static Gson gson = new Gson();

    public static void main(String[] args) {
        String pathForModel = Paths.get("src/main/java/org/example/task3", "tests.json").toString();
        String pathForUpdate = Paths.get("src/main/java/org/example/task3", "values.json").toString();
        String pathForNewFileWithUpdate = Paths.get("src/main/java/org/example/task3", "report.json").toString();

        generateNewJsonFile(pathForModel, pathForUpdate, pathForNewFileWithUpdate);
    }

    private static void generateNewJsonFile(String pathForModel, String pathForUpdate, String pathForNewFileWithUpdate) {
        try (
                FileReader fileReader = new FileReader(pathForModel);
                FileReader fileReader1 = new FileReader(pathForUpdate)
        ) {
            Tests tests = gson.fromJson(fileReader, Tests.class);
            Values values = gson.fromJson(fileReader1, Values.class);

            updateValues(tests.getTests(), values.getValues());

            Files.write(Paths.get(pathForNewFileWithUpdate), gson.toJson(tests).getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateValues(List<Test> tests, List<Value> values) {
        for (Test test : tests) {
            for (Value value : values) {
                if (test.values != null) {
                    updateValues(test.values, values);
                }
                if (test.getId() == value.getId()) {
                    test.setValue(value.getValue());
                }
            }
        }
    }

    public static class Tests {
        @SerializedName("tests")
        private List<Test> tests;

        public List<Test> getTests() {
            return tests;
        }

        @Override
        public String toString() {
            return "Tests{" +
                    "tests=" + tests +
                    '}';
        }
    }

    public static class Test {
        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("value")
        private String value;
        @SerializedName("values")
        private List<Test> values;

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getValue() {
            return value;
        }

        public List<Test> getValues() {
            return values;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setValues(List<Test> values) {
            this.values = values;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", value='" + value + '\'' +
                    ", values=" + values +
                    '}';
        }
    }

    public static class Values {
        @SerializedName("values")
        private List<Value> values;

        public List<Value> getValues() {
            return values;
        }

        @Override
        public String toString() {
            return "Values{" +
                    "values=" + values +
                    '}';
        }
    }

    public static class Value {
        @SerializedName("id")
        private int id;
        @SerializedName("value")
        private String value;

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
