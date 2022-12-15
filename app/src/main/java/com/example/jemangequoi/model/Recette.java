package com.example.jemangequoi.model;

import java.util.List;

public class Recette {

    private String nomRecette;
    private String typeRecette;
    //private List<Aliment> alimentsRecette;
    private List<String> alimentsRecette;
    private List<String> restrictions;

    public Recette(String nomRecette, String typeRecette, List<String> restrictions, List<String> alimentsRecette) {
        this.nomRecette = nomRecette;
        this.typeRecette = typeRecette;
        this.restrictions = restrictions;
        this.alimentsRecette = alimentsRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public String getTypeRecette() {
        return typeRecette;
    }

    public void setTypeRecette(String typeRecette) {
        this.typeRecette = typeRecette;
    }

    public List<String> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<String> restrictions) {
        this.restrictions = restrictions;
    }

    public List<String> getAlimentsRecette() {
        return alimentsRecette;
    }

    public void setAlimentsRecettes(List<String> alimentsRecette) {
        this.alimentsRecette = alimentsRecette;
    }

}
