/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amkane.schoodent.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author amkane
 */
@Entity
public class Classe implements Serializable{
    
    @Id @GeneratedValue
    private Long id;
    private String nom;
    private String annee;

    public Classe() {
    }

    public Classe(String nom, String annee) {
        this.nom = nom;
        this.annee = annee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRang() {
        return annee;
    }

    public void setRang(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", nom=" + nom + ", annee=" + annee + '}';
    }
    
    
    
}
