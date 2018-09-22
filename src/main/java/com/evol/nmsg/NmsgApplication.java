package com.evol.nmsg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.evol.nmsg.mapper")
public class NmsgApplication {

    public static void main(String[] args) {
        SpringApplication.run(NmsgApplication.class, args);
    }
}
