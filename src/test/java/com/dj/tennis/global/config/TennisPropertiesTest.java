package com.dj.tennis.global.config;

import com.dj.tennis.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(properties = "tennis.open-day=25")
@Import(TestcontainersConfiguration.class)
class TennisPropertiesTest {

    @Autowired
    TennisProperties props;

    @Test
    void bindsFromYmlAndOverrides() {
        assertThat(props.openDay()).isEqualTo(25);
        assertThat(props.openHour()).isEqualTo(10);
        assertThat(props.burstDurationMin()).isEqualTo(60);
    }
}