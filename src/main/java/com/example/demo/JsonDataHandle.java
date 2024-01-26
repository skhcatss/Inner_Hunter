package com.example.demo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;



public class JsonDataHandle {

    public JsonDataHandle() {
    }

    public static Map datahandle(String jsonString){

        Map hashMap = new HashMap();


        try {
            // 创建ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();

            // 将JSON字符串解析为JsonNode对象
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            // 从JsonNode中获取需要的数据
            //响应码
            String code = jsonNode.get("code").asText();
            hashMap.put("code",code);

            //响应简短描述信息
            String message = jsonNode.get("message").asText();
            hashMap.put("message",message);


            // 获取data节点下的信息
            //账户类型
            JsonNode dataNode = jsonNode.get("data");
            String account_type = dataNode.get("account_type").asText();
            hashMap.put("account_type",account_type);

            //总条数
            String total = dataNode.get("total").asText();
            hashMap.put("total",total);

            //int time = dataNode.get("time").asInt();

            // 获取arr数组节点下的信息
            JsonNode arrNode = dataNode.get("arr");
            hashMap.put("arrNode",arrNode);

            // 获取consume_quota和rest_quota信息
            //消耗积分
            String consume_quota = dataNode.get("consume_quota").asText();
            hashMap.put("consume_quota",consume_quota);

            //剩余积分等信息
            String rest_quota = dataNode.get("rest_quota").asText();
            hashMap.put("rest_quota",rest_quota);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;

    }

}
