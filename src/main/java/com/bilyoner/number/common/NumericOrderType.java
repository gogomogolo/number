package com.bilyoner.number.common;

public enum NumericOrderType {
    DESC("desc"),
    ASC("asc");

    private final String value;

    NumericOrderType(String value) {
        this.value = value;
    }
}
