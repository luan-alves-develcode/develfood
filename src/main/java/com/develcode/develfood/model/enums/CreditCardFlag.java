package com.develcode.develfood.model.enums;

public enum CreditCardFlag {
    MASTERCARD("Mastercard"),
    VISA("Visa"),
    ELO("Elo"),
    DINERSCLUB("Diners Club"),
    AMERICANEXPRESS("American Express"),
    HIPERCARD("Hipercard"),
    ALELO("Alelo");

    private String name;

    CreditCardFlag(String name) { this.name = name; }
}
