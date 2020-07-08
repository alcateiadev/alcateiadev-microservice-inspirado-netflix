package com.br.alcateiadev.netflix.netflix.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatusResource {

    @GetMapping(path = "/status")
    @ResponseBody
    public String status() {
        return "OK";
    }

    @GetMapping(path = "/health")
    @ResponseBody
    public String health() {
        return "OK";
    }



}
