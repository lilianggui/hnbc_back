package com.llg.hnbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "com.llg.hnbc")
@ServletComponentScan
@MapperScan("com.llg.hnbc.mapper.dao")
public class HnbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HnbcApplication.class, args);
    }

}
