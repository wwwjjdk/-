package org.example.task3;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Test {
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
