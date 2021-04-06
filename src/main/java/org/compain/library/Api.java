package org.compain.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("org.compain.library.consumer")
@SpringBootApplication
@EnableTransactionManagement
public class Api {
    public static void main(String[] args) {
        SpringApplication.run(Api.class, args);
    }}
