package com.tengxt.propertiesspringboot.Controller;

import com.tengxt.propertiesspringboot.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Config config;

    @GetMapping("/configAll")
    public String config(){
        return config.getServers().toString();
    }
}
