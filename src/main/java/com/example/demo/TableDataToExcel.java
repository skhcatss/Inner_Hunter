package com.example.demo;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.csv.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class TableDataToExcel {

    public static String toExcel(String jsonString) {

        CSVFormat format = CSVFormat.DEFAULT.withHeader("IP", "端口", "域名", "IP标签", "url", "网站标题", "高危协议", "协议", "通讯协议", "网站状态码", "应用/组件", "操作系统", "备案单位", "备案号", "国家", "省份", "市区", "探查时间", "Web资产", "运营商", "注册机构");
        Map res = JsonDataHandle.datahandle(jsonString);
        JsonNode arrNode = (JsonNode) res.get("arrNode");

        String currentDirectory = System.getProperty("user.dir");
        long currentTimestamp = System.currentTimeMillis();

        String csvName = currentDirectory +"/Hunter-out"+currentTimestamp+".csv";


        try (FileWriter out = new FileWriter(csvName);
             CSVPrinter printer = new CSVPrinter(out, format)) {

        for (JsonNode itemNode : arrNode) {
            //1-IP
            String ip = itemNode.get("ip").asText();
            //2-端口
            String port = itemNode.get("port").asText();
            //3-域名
            String domain = itemNode.get("domain").asText();
            //4-IP标签  null
            String ip_label = "";
            //5-url
            String url_res = itemNode.get("url").asText();
            //6-网站标题
            String web_title = itemNode.get("web_title").asText();
            //7-高危协议
            String is_risk_protocol = itemNode.get("is_risk_protocol").asText();
            //8-协议
            String protocol = itemNode.get("protocol").asText();
            //9-通讯协议
            String base_protocol = itemNode.get("base_protocol").asText();
            //10-网站状态码
            String status_code = itemNode.get("status_code").asText();
            //11-应用/组件
            String component = itemNode.get("component").asText();
            //12-操作系统
            String os = itemNode.get("os").asText();
            //13-备案单位
            String company = itemNode.get("company").asText();
            //14-备案号
            String number = itemNode.get("number").asText();
            //15-国家
            String country = itemNode.get("country").asText();
            //16-省份
            String province = itemNode.get("province").asText();
            //17-市区
            String city = itemNode.get("city").asText();
            //18-探查时间
            String updated_at = itemNode.get("updated_at").asText();
            //19-Web资产
            String is_web = itemNode.get("is_web").asText();
            //20-运营商
            String isp = itemNode.get("isp").asText();
            //21-注册机构
            String as_org = itemNode.get("as_org").asText();

            printer.printRecord(ip, port, domain,ip_label, url_res, web_title, is_risk_protocol, protocol, base_protocol, status_code, component, os, company, number, country, province, city, updated_at, is_web, isp, as_org);

        }
        return  "导出成功:"+csvName+"\n";


        } catch (IOException e) {
            return "导出失败"+e+"\n";
            //throw new RuntimeException(e);

        }


    }

}
