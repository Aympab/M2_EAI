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
    
    
}
