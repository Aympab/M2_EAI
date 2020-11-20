/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.sharedvolume.objects;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aympa
 */
public class Volume implements Serializable {
    //ATTRIBUTS

    private int numero;

    private ArrayList<Article> listeArticles;

    private ArrayList<Publicite> listePublicites;

    private int id;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Article> getListeArticles() {
        return listeArticles;
    }

    public void setListeArticles(ArrayList<Article> listeArticles) {
        this.listeArticles = listeArticles;
    }

    public ArrayList<Publicite> getListePublicites() {
        return listePublicites;
    }

    public void setListePublicites(ArrayList<Publicite> listePublicites) {
        this.listePublicites = listePublicites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String ret = "numero : " + this.getNumero();

        System.out.println("\t\t\tArticles : ");
        this.getListeArticles().forEach((a) -> {
            System.out.println("\t\t\t\tID : " + a.getId() + "\n\t\t\t\t\t" + a.getAuteur() + " - " + a.getNom() + " - " + a.getContenu());
        });

        System.out.println("\t\t\tPubs : ");
        this.getListePublicites().forEach((p) -> {
            System.out.println("\t\t\t\tID : " + p.getIdPub() + "\n\t\t\t\t\t" + p.getNom() + " - " + p.getContenu());
        });

        return ret;
    }
}
