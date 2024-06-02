package org.example.task3;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tests {
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
