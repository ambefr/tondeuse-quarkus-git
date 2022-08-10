package com.far.apps.domain;

/**
 * Enumération des orientations
 */
public enum Orientations {
    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S");

    private final String value;
    private Orientations(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
