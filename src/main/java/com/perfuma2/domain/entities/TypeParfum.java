package com.perfuma2.domain.entities;

public enum TypeParfum {
    ORIENTAL(""),
    WOODY(""),
    CITRIC("");

    public String description;

    TypeParfum(String description){
        this.description = description;
    }

    public String getTypeDescription(){
        return description;
    }
}
