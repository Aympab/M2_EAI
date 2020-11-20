/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServicePresseLocal {

//    public void traiterArticles(ArrayList<Article> listeArt);
    
    /**
     * Permet d'envoyer une notifiaction texte à l'app redac
     */
    public void notifierAppRedac();
    
//    /**
//     * Récupère les pubs présentes dans la queue PUBINIT et les stocke dans le singleton
//     * @param listePub
//     */
//    public void recupererPub(ArrayList<Publicite> listePub);
    
    public ArrayList<Volume> getVolumesAEnvoyer();
            
    public void transfererVolumesArchive();
    public void transfererVolumesDistribution();
    
    public ArrayList<Volume> selectionnerVolumePourEnvoi(int idVolume);
    
    public void printAllStock();
    
    
    public void transfererTitresArchive();
    
    public ArrayList<Titre> selectionnerTitrePourEnvoi(int idTitre);
    
    //public void transfererVolumeVersDistrib(Volume v);
}
