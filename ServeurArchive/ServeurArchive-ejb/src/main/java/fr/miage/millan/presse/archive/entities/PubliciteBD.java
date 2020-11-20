/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 *
 * @author aympa
 */
@Entity
public class PubliciteBD implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String nom;

    private String contenu;

    public PubliciteBD() {
    }

    public PubliciteBD(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    
    
//    public PubliciteBD(Integer idpublicite) {
//        this.id = idpublicite;
//    }

    public Integer getIdpublicite() {
        return id;
    }

    public void setIdpublicite(Integer idpublicite) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PubliciteBD)) {
            return false;
        }
        PubliciteBD other = (PubliciteBD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.millan.entities.Publicite[ idpublicite=" + id + " ]";
    }
    
}
