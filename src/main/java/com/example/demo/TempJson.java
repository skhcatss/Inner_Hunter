package com.example.demo;

public class TempJson {
    private String json_str;

    public TempJson(String json_str) {
        this.json_str = json_str;
    }

    public TempJson() {
    }

    public String getJson_str() {
        return json_str;
    }

    public void setJson_str(String json_str) {
        this.json_str = json_str;
    }

    @Override
    public String toString() {
        return "TempJson{" +
                "json_str='" + json_str + '\'' +
                '}';
    }
}
