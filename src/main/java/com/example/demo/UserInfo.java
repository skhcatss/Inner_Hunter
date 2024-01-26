package com.example.demo;

public class UserInfo {
    private  String apikey; //APIKEY
    private String encodedString; //请求内容base64编码
    private String model;  //1 内网hunter 2外网hunter
    private int page; //页码
    private  int page_size; //每页资产条数
    private String is_web; //是否web
    private String start_time;  //开始时间
    private String end_time; //结束时间

    public UserInfo() {
    }

    public UserInfo(String apikey, String encodedString, String model, int page, int page_size, String is_web, String start_time, String end_time) {
        this.apikey = apikey;
        this.encodedString = encodedString;
        this.model = model;
        this.page = page;
        this.page_size = page_size;
        this.is_web = is_web;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEncodedString() {
        return encodedString;
    }

    public void setEncodedString(String encodedString) {
        this.encodedString = encodedString;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public String getIs_web() {
        return is_web;
    }

    public void setIs_web(String is_web) {
        this.is_web = is_web;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
