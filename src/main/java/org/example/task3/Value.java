package org.example.task3;

import com.google.gson.annotations.SerializedName;

public class Value {
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
