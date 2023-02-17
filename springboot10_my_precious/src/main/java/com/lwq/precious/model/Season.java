package com.lwq.precious.model;

public enum Season {
    
    SPRING("春", "困"),
    SUMMER("夏", "蚊"),
    AUTUMN("秋", "乏"),
    WINTER("冬", "冷");

    private final String seasonName;
    private final String seasonDescription;

    // get方法
    public String getSeasonName() {
        return seasonName;
    }

    // get方法
    public String getSeasonDescription() {
        return seasonDescription;
    }

    private Season(String seasonName, String seasonDescription) {
        this.seasonName = seasonName;
        this.seasonDescription = seasonDescription;
    }
}
