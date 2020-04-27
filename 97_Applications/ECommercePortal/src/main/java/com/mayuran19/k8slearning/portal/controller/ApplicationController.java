package com.mayuran19.k8slearning.portal.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ApplicationController {
    @Value("${product.url}")
    private String productURL;

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Hello from boot: " + inetAddress.getHostName());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(productURL, String.class);
        return "Hello portal : " + inetAddress.getHostName() + " : " + response.getBody();
    }
}
