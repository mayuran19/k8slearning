package com.mayuran19.k8slearning.productservice.controller;

import com.mayuran19.k8slearning.productservice.dao.SystemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ApplicationController {
    @Autowired
    private SystemDAO systemDAO;
    @Value("${inventory.url}")
    private String inventoryURL;

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Hello from boot: " + inetAddress.getHostName());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(inventoryURL, String.class);
        return "Hello product: " + inetAddress.getHostName() + ":" + systemDAO.getCurrentTimestamp() + response.getBody();
    }
}
