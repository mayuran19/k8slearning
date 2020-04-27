package com.mayuran19.k8slearning.inventoryservice.controller;

import com.mayuran19.k8slearning.inventoryservice.dao.SystemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class ApplicationController {
    @Autowired
    private SystemDAO systemDAO;

    @RequestMapping("/")
    public String index() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("Hello from boot: " + inetAddress.getHostName());
        return "Hello inventory: " + inetAddress.getHostName() + ":" + systemDAO.getCurrentTimestamp();
    }
}
