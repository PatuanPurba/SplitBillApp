package com.SplitBill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.SplitBill"})
@EnableJpaRepositories(basePackages = "com.SplitBill.repository")
@EntityScan(basePackages = "com.SplitBill.domain")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
