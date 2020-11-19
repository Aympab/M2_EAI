/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.appPub.services;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServicePubliciteLocal {
 
    /**
     * Permet de générer une pub et e l'ajouter à la liste des pubs à envoyer
     * @param nomPub Le titre de la pub
     * @param contenu Le contenu de la pub sous forme de texte
     */
    public void creerPublicitePourEnvoi(String nomPub, String contenu);
    
    /**
     * Envoie la liste de pub selectionnées
     */
    public void envoyerPublicites();
    
    public ArrayList<Publicite> getListeEnvoi();
}
