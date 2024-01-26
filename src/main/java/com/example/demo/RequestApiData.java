package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Objects;


public class RequestApiData {

    public RequestApiData() {
    }


    public static <UnknownHostException extends Throwable> String RequestHunter(UserInfo usinfo) throws IOException {



        String ApiKey = usinfo.getApikey(); //APIKEY
        String encodedString = usinfo.getEncodedString();//查询语法
        int page = usinfo.getPage();//页码
        int page_size = usinfo.getPage_size();//每页资产条数
        int is_web = Objects.equals(usinfo.getIs_web(), "web资产") ? 1:(Objects.equals(usinfo.getIs_web(), "非web资产") ? 2:3); //请求类型
        String start_time = usinfo.getStart_time();//开始时间
        String end_time = usinfo.getEnd_time();//结束时间
        String model = usinfo.getModel();//鹰图模式
        String endHostName = Objects.equals(model,"内部鹰图") ? "https://inner.hunter.qianxin-inc.cn/" : "https://hunter.qianxin.com/";



        StringBuilder sb = new StringBuilder();
        sb.append(endHostName).append("openApi/search?api-key=").append(ApiKey).append("&search=").append(encodedString).append("&page=").append(page).append("&page_size=").append(page_size).append("&is_web=").append(is_web).append("&start_time=").append(start_time).append("&end_time=").append(end_time);
        String domain = sb.toString();
        System.out.println(domain);

        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"; // 替换为您想要的正常UA
        try {
        URL url = new URL(domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", userAgent);

        connection.setConnectTimeout(8000);

        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);


        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // 打印响应内容
        //System.out.println("Response: " + response.toString());
        return response.toString();

     }catch (java.net.UnknownHostException e) {

         return "Error:UnknownHostException";


    }



    }

}
