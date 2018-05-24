package it.gunnegan.entity.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    U6(10L, "UNDER 6"),
    U8(20L, "UNDER 8"),
    U10(30L, "UNDER 10"),
    U12(40L, "UNDER 12"),
    U14(50L, "UNDER 14"),
    U16(60L, "UNDER 16"),
    U18(70L, "UNDER 18"),
    SENIORES(80L, "SENIORES");

    private Long code;
    private String description;

    @JsonValue
    public Long getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    Category(Long code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonCreator
    public static Category find(int code) {
        for (Category l : values()) {
            if (l.code == code) {
                return l;
            }
        }

        throw new IllegalArgumentException("Wrong Category " + code);
    }

}