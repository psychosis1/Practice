package org.company.data;

public enum SexEnum {
    MALE("Мужчина"), FEMALE("Женщина");

    private final String value;

    SexEnum(String value) {
        this.value = value;
    }

    public static SexEnum getEnum(String value) {
        if (value.equals(MALE.value)) {
            return MALE;
        } else if (value.equals(FEMALE.value)) {
            return FEMALE;
        }
        return null;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
