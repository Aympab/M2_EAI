/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServicePresseLocal {

    public void recupererArticle();
    
    /**
     * Permet d'envoyer une notifiaction texte à l'app redac
     */
    public void notifierAppRedac();
}
