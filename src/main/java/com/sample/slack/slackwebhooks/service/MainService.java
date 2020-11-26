package com.sample.slack.slackwebhooks.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {

    @Value("${slack.webhooks}")
    String WEBHOOKS;

    @Value("${slack.username}")
    String USERNAME;

    public void sendMsg(String msg) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> request = new HashMap<String, Object>();
        request.put("username", USERNAME);
        request.put("text", msg);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(request);

        ResponseEntity<String> result = restTemplate.exchange(WEBHOOKS, HttpMethod.POST, entity, String.class);

        System.out.println(result);
        
	}
    
}
