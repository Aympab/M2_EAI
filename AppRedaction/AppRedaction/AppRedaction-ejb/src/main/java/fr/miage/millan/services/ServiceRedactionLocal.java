/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.services;

import fr.miage.millan.entities.Article;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceRedactionLocal {
    
    public void creerArticle(String nomArticle, ArrayList<String> motClefs, String contenu, String auteur);

   //Envoie la liste d'article en attente
    public void envoyerListeArticles();
    
    //Selectionne un article pour l'ajouter à la liste d'attente
    public void selectionnerArticles(Article art);
    
    public ArrayList<Article> getArticles();
    
}


