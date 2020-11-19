/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.sharedpubpresse.objects;

import java.io.Serializable;

/**
 *
 * @author aympa
 */
public class Publicite implements Serializable {
    private String nom;
    private String contenu;

    public Publicite(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
}
