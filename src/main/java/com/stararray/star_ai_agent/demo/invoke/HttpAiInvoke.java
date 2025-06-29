package com.stararray.star_ai_agent.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class HttpAiInvoke {
    public static void main(String[] args) {
        // 替换为你的实际API密钥
        String apiKey = TestApiKey.API_KEY;
        
        // 构建请求体JSON
        JSONObject requestBody = new JSONObject();
        requestBody.set("model", "qwen-plus");
        
        JSONObject systemMessage = new JSONObject();
        systemMessage.set("role", "system");
        systemMessage.set("content", "You are a helpful assistant.");
        
        JSONObject userMessage = new JSONObject();
        userMessage.set("role", "user");
        userMessage.set("content", "你是谁？");
        
        requestBody.set("messages", JSONUtil.createArray().put(systemMessage).put(userMessage));
        
        // 发送请求
        String response = HttpRequest.post("https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .execute()
                .body();
        
        System.out.println(response);
    }
}