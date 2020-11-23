/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.shareddistributeurs.objs;

import fr.miage.millan.presse.sharedvolume.objects.Titre;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aympa
 */
public class ContratDistributeur implements Serializable{

    private int idContrat;
    private int nbCopies;
    //En jours
    private int dureeContrat;
    private boolean contratValide;
    private float cout;
    private String nomDistrib;
    private boolean recepisseValide;
    private ArrayList<Titre> titresDiffuses;

    public int getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }

    public int getNbCopies() {
        return nbCopies;
    }

    public void setNbCopies(int nbCopies) {
        this.nbCopies = nbCopies;
    }

    public int getDureeContrat() {
        return dureeContrat;
    }

    public void setDureeContrat(int dureeContrat) {
        this.dureeContrat = dureeContrat;
    }

    public boolean isContratValide() {
        return contratValide;
    }

    public void setContratValide(boolean contratValide) {
        this.contratValide = contratValide;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public String getNomDistrib() {
        return nomDistrib;
    }

    public void setNomDistrib(String nomDistrib) {
        this.nomDistrib = nomDistrib;
    }

    public boolean isRecepisseValide() {
        return recepisseValide;
    }

    public void setRecepisseValide(boolean recepisseValide) {
        this.recepisseValide = recepisseValide;
    }

    public ArrayList<Titre> getTitresDiffuses() {
        return titresDiffuses;
    }

    public void setTitresDiffuses(ArrayList<Titre> titresDiffuses) {
        this.titresDiffuses = titresDiffuses;
    }
    
    @Override
    public String toString(){
        return ""+this.nomDistrib + " - cout : " + this.cout +  ", dureeContrat : "+this.dureeContrat + ", nbCopies : "+this.nbCopies;
    }
    
}
