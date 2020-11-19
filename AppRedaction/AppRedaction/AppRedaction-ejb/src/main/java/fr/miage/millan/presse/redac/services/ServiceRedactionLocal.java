/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.redac.services;

import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceRedactionLocal {
    
    /**
     * Créer un article et ajout dans la BD (qui n'en est pas une pour le projet)
     * @param nomArticle
     * @param motClefs
     * @param contenu
     * @param auteur 
     */
    public void creerArticle(String nomArticle, ArrayList<String> motClefs, String contenu, String auteur);

   //Envoie la liste d'article en attente vers l'application MiseSousPresse
    public void envoyerListeArticles();
    
    /**
     * Permet d'ajouter des articles qui sont dans la "bdArticle" vers la liste d'articles à envoyer.
     * @param idArticleSelectionne L'id de l'article qu'on veut ajouter à la liste d'articles à envoyer
     * @return la liste des articles à envoyer mise à jour
     */
    public ArrayList<Article> selectionnerArticle(Long idArticleSelectionne);
    
    public ArrayList<Article> getAllArticles();
    
    /**
     * Permet de traiter les notifications de la queue PRESSE_NOTIF_REDAC lorsqu'on en reçoit une
     * @param notif
     */
    public void traiterNotification(String notif);
}


