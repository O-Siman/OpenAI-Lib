package com.columbushs.openailib.utils;

import com.columbushs.openailib.objects.OpenAIResponse;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class OpenAIUtils {
    private static final String apiKey = System.getenv("OPENAI_API_KEY");
    private static final Gson gson = new Gson();

    public static String completion(String prompt, double temperature, int maxTokens) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/engines/text-davinci-002/completions");
        httpPost.addHeader("Authorization", "Bearer " + apiKey);
        httpPost.addHeader("Content-Type", "application/json");

        HashMap<String, Object> rootJson = new HashMap<>();
        rootJson.put("prompt", prompt);
        rootJson.put("temperature", temperature);
        rootJson.put("max_tokens", maxTokens);
        try {
            httpPost.setEntity(new StringEntity(gson.toJson(rootJson)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }

        CloseableHttpResponse response;
        String responseString;
        try {
            response = httpClient.execute(httpPost);
            responseString = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println(responseString);
        OpenAIResponse openAIResponse = gson.fromJson(responseString, OpenAIResponse.class);
        return openAIResponse.getChoices().get(0).getText();
    }
}

