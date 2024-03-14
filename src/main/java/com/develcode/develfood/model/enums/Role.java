package com.develcode.develfood.model.enums;

public enum Role {
    CUSTOMER ("Cliente"),
    RESTAURANT ("Restaurante");

    private String name;
    Role(String name) {
        this.name = name;
    }
}
