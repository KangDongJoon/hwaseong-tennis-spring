package com.dj.tennis.domain.court;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Courts {

    public static final List<Court> ALL = List.of(
            new Court(213, "돌모루", 8),
            new Court(245, "중동", 1),
            new Court(246, "중동", 2),
            new Court(212, "금반저류지", 1),
            new Court(243, "금반저류지", 2),
            new Court(193, "여울공원", 1),
            new Court(195, "여울공원", 2),
            new Court(196, "여울공원", 3),
            new Court(230, "왕배산", 1),
            new Court(231, "왕배산", 2),
            new Court(235, "왕배산", 5),
            new Court(236, "왕배산", 6),
            new Court(237, "왕배산", 7),
            new Court(238, "왕배산", 8));

    public static final Map<Integer, Court> BY_ID = ALL.stream()
            .collect(Collectors.toUnmodifiableMap(Court::id, Function.identity()));

    /** 목록에 처음 나온 순서대로의 시설 이름 */
    public static final List<String> FACILITIES = ALL.stream().map(Court::facility).distinct().toList();

    private Courts() {
    }

    /** facilities가 비어 있으면 전체 */
    public static List<Integer> idsOf(Collection<String> facilities) {
        return ALL.stream()
                .filter(c -> facilities == null || facilities.isEmpty() || facilities.contains(c.facility()))
                .map(Court::id)
                .toList();
    }

    public static String reserveUrl(String baseUrl, int courtId) {
        return baseUrl + "/1053/3026/stadiumDetail.do?stadiumIdx=" + courtId;
    }
}