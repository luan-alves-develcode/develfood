package com.develcode.develfood.model;

public enum PaymentType {
    CARTAODEBITO("Cartão de Débito"), CARTAOCREDITO("Cartão de Cŕedito"), PIX("Pix"), DINHEIRO("Dinheiro");

    PaymentType(String name) {
    }
}
