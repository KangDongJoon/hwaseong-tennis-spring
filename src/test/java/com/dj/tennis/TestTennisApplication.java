package com.dj.tennis;

import org.springframework.boot.SpringApplication;

public class TestTennisApplication {

    public static void main(String[] args) {
        SpringApplication.from(TennisApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
