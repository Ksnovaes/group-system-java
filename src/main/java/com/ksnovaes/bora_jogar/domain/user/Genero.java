package com.ksnovaes.bora_jogar.domain.user;

public enum Genero {
    MASCULINO(1),
    FEMININO(2);

    private int value;

    private Genero(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
