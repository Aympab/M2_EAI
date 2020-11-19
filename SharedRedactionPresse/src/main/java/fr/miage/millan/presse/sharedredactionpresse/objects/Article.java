/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.sharedredactionpresse.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aympa
 */
public class Article implements Serializable {

    //ATTRIBUTS
    String nom;
    ArrayList<String> motClefs;
    String contenu;
    String auteur;

    
    //
    //
    //CONSTRUCTOR
    public Article(String nom, ArrayList<String> motClefs, String contenu, String auteur) {
        this.nom = nom;
        this.motClefs = motClefs;
        this.contenu = contenu;
        this.auteur = auteur;
    }

    public Article(String nom, String contenu, String auteur) {
        this.nom = nom;
        this.contenu = contenu;
        this.auteur = auteur;
    }

    public Article(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }
    
    
//    //JEE RELATED
    private int id;

    
    //
    //
    //GETTERS & SETTERS
    //
    //
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getMotClefs() {
        return motClefs;
    }

    public void setMotClefs(ArrayList<String> motClefs) {
        this.motClefs = motClefs;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
