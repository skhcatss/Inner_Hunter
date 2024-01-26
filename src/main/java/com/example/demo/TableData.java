package com.example.demo;

public class TableData {
    public String ip;
    public String url_res;
    public String port;
    public String web_title;
    public String domain;
    public String is_risk_protocol;
    public String component;
    public String os;
    public String company;

    public String number;
    public String country;


    public TableData(String ip, String url_res, String port, String web_title, String domain, String is_risk_protocol, String component, String os, String company, String number, String country) {
        this.ip = ip;
        this.url_res = url_res;
        this.port = port;
        this.web_title = web_title;
        this.domain = domain;
        this.is_risk_protocol = is_risk_protocol;
        this.component = component;
        this.os = os;
        this.company = company;
        this.number = number;
        this.country = country;
    }

    public TableData() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl_res() {
        return url_res;
    }

    public void setUrl_res(String url_res) {
        this.url_res = url_res;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getWeb_title() {
        return web_title;
    }

    public void setWeb_title(String web_title) {
        this.web_title = web_title;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getIs_risk_protocol() {
        return is_risk_protocol;
    }

    public void setIs_risk_protocol(String is_risk_protocol) {
        this.is_risk_protocol = is_risk_protocol;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "ip='" + ip + '\'' +
                ", url_res='" + url_res + '\'' +
                ", port='" + port + '\'' +
                ", web_title='" + web_title + '\'' +
                ", domain='" + domain + '\'' +
                ", is_risk_protocol='" + is_risk_protocol + '\'' +
                ", component='" + component + '\'' +
                ", os='" + os + '\'' +
                ", company='" + company + '\'' +
                ", number='" + number + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

