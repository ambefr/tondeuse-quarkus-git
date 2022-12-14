package com.far.apps.domain;

/**
 * Enumération des instructions
 */
public enum Instructions {
    AVANCER("A"),
    GAUCHE("G"),
    DROITE("D");

    private final String value;
    private Instructions(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
