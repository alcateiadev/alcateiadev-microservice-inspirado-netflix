package com.br.alcateiadev.netflix.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableZuulProxy
public class NetflixApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixApplication.class, args);
    }

}
