package com.dj.tennis.global.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tennis")
public record TennisProperties(
        int openDay,
        int openHour,
        int burstDurationMin
) {
}
