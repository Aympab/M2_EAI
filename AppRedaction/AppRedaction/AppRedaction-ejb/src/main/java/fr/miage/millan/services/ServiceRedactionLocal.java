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
    
    /**
     * Permet d'ajouter des articles qui sont dans la "bdArticle" vers la liste d'articles à envoyer.
     * @param idArticleSelectionne L'id de l'article qu'on veut ajouter à la liste d'articles à envoyer
     * @return la liste des articles à envoyer mise à jour
     */
    public ArrayList<Article> selectionnerArticles(Long idArticleSelectionne);
    
    public ArrayList<Article> getArticles();
    
    /**
     * Permet de récupérer les notifications de la queue PRESSE_NOTIF_REDAC
     * @return vrai s'il y a au moins une notif, false sinon
     */
    public boolean recevoirNotification();
}


