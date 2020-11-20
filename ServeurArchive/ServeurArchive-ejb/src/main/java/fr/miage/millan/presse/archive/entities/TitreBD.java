/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author aympa
 */
@Entity
public class TitreBD implements Serializable {
    //ATTRIBUTS
    private String nom;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private ArrayList<VolumeBD> listeVolumes;
    
    //JEE
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TitreBD)) {
            return false;
        }
        TitreBD other = (TitreBD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.millan.presse.archive.entities.Titre[ id=" + id + " ]";
    }
 
    
    
    //GETTERS & SETTERS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<VolumeBD> getListeVolumes() {
        return listeVolumes;
    }

    public void setListeVolumes(ArrayList<VolumeBD> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }
    
}
