/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServicePresseLocal {

    public void traiterArticles(ArrayList<Article> listeArt);
    
    /**
     * Permet d'envoyer une notifiaction texte à l'app redac
     */
    public void notifierAppRedac();
    
    /**
     * Récupère les pubs présentes dans la queue PUBINIT et les stocke dans le singleton
     */
    public void recupererPub(ArrayList<Publicite> listePub);
    
    public void printAllStock();
    
//    public void transfererVolumeVersDistrib(Volume v);
}
