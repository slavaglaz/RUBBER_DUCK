package ru.cft.shift.qa.test.yellowrubberduck;

public enum BasePath {
    DUCK("/api/duck");

    private String value;

    BasePath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
