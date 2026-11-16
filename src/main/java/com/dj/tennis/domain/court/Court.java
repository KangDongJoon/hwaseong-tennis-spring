package com.dj.tennis.domain.court;

public record Court(int id, String facility, int courtNo) {

    public String name() {
        return facility + " " + courtNo + "번";
    }
}