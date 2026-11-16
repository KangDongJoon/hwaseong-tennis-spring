package com.dj.tennis.domain.court;

import static org.assertj.core.api.Assertions.assertThat;

import com.dj.tennis.domain.court.Courts;
import org.junit.jupiter.api.Test;

import java.util.List;

class CourtsTest {

    @Test
    void facilitiesKeepFirstAppearanceOrder() {
        assertThat(Courts.FACILITIES)
                .containsExactly("돌모루", "중동", "금반저류지", "여울공원", "왕배산");
    }

    @Test
    void idsOfSelectFacility() {
        assertThat(Courts.idsOf(List.of("금반저류지"))).containsExactly(212, 243);
        assertThat(Courts.idsOf(List.of("중동"))).containsExactly(245, 246);
    }

    @Test
    void emptySelectionMeansAllCourts() {
        assertThat(Courts.idsOf(List.of())).hasSize(14);
        assertThat(Courts.idsOf(null)).hasSize(14);
    }

    @Test
    void findCourtById() {
        assertThat(Courts.BY_ID.get(230).name()).isEqualTo("왕배산 1번");
    }
}

