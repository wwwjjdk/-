package org.example.task3;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Values {
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
