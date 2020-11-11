/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author aympa
 */
@Entity
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
    
    
    //JEE RELATED
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    //
    //
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
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "fr.miage.millan.entities.Article[ id=" + id + " ]";
    }
    
}
