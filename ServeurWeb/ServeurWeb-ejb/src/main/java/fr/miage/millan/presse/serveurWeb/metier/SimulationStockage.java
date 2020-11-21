/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.metier;

import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;

/**
 *
 * @author astrid
 */
public final class SimulationStockage {
    
    private static final ArrayList<Titre> titresEnStock = new ArrayList<Titre>();
    
    private static int idTitre = 0;
    
    public static void ajouterTitre() {
        Titre t = new Titre();
        t.setNom("Titre1");
        t.setId(idTitre);
        idTitre += 1;
        titresEnStock.add(t);
        
        Article a = new Article("ARTICLE 1", "CONTENU ARTICLE 1", "AUTEUR ARTICLE 1");
        Publicite p = new Publicite("PUBLICITE 1", "CONTENU PUBLICITE 1");
        Article a2 = new Article("ARTICLE 2", "CONTENU ARTICLE 2", "AUTEUR ARTICLE 2");
        Publicite p2 = new Publicite("PUBLICITE 2", "CONTENU PUBLICITE 2");
        
        ArrayList<Article> listeArticles = new ArrayList();
        ArrayList<Publicite> listePublicites = new ArrayList();
        
        listeArticles.add(a);
        listePublicites.add(p);
        listePublicites.add(p2);
        
        Volume v = new Volume();
        v.setNumero(1);
        v.setListeArticles(listeArticles);
        v.setListePublicites(listePublicites);
        
        
        ArrayList<Article> listeArticles_2 = new ArrayList();
        ArrayList<Publicite> listePublicites_2 = new ArrayList();
        
        listeArticles_2.add(a);
        listeArticles_2.add(a2);
        listePublicites_2.add(p);
        
        Volume v2 = new Volume();
        v2.setNumero(1);
        v2.setListeArticles(listeArticles_2);
        v2.setListePublicites(listePublicites_2);
        
        ArrayList<Volume> listeVolumes = new ArrayList<>();
        listeVolumes.add(v);
        listeVolumes.add(v2);
        
        t.setListeVolumes(listeVolumes);
        
        
        
        
        
        
        Titre t2 = new Titre();
        t2.setNom("Titre2");
        t2.setId(idTitre);
        idTitre += 1;
        titresEnStock.add(t2);
    }
    
    public static ArrayList<Titre> getStockTitre() {
        ajouterTitre();
        return titresEnStock;
    }
    
}
