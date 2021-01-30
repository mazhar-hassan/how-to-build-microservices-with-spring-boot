package com.ptv.livebox.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HealthController {

    @Autowired
    DataSource dataSource;

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/datasource")
    public String datasource() {
        System.out.println(dataSource);
        return dataSource.toString();
    }
}
