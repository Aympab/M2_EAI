/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.sharedvolume.objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aympa
 */
public class Titre implements Serializable {

    private ArrayList<Volume> listeVolumes;
    private String nom;
    private int id;
    
    @Override
    public String toString() {
        String ret = "Titre : " + nom;
        for (Volume v : listeVolumes) {
            ret += v.toString();
        }
        return ret;
    }

    public ArrayList<Volume> getListeVolumes() {
        return listeVolumes;
    }

    public void setListeVolumes(ArrayList<Volume> listeVolumes) {
        this.listeVolumes = listeVolumes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

}
