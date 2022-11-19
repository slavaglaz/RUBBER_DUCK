package ru.cft.shift.qa.test.yellowrubberduck;

public enum Directory {
    FLY("/fly"),
    PROPERTIES("/properties"),
    SOUND("/sound"),
    SWIM("/swim");

    private String value;

    Directory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
