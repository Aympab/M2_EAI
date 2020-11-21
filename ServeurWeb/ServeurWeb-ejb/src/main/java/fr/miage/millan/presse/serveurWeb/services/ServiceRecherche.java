/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.services;

import fr.miage.millan.presse.serveurWeb.metier.SimulationStockage;
import fr.miage.millan.presse.sharedredactionpresse.objects.Article;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceRecherche implements ServiceRechercheLocal {
    
    ArrayList<Titre> listeTitres = SimulationStockage.getStockTitre();

    @Override
    public ArrayList<Titre> getJsonTitre() {
        return listeTitres;
    }

    @Override
    public ArrayList<Titre> getJsonTitreMotsClefs(String motClef) {
        
        ArrayList<Titre> liste = new ArrayList();
        
        for(Titre t : listeTitres){
            for (Volume v : t.getListeVolumes()) {
                for (Article a : v.getListeArticles()) {
                    if (a.getMotClefs().contains(motClef)){
                        liste.add(t);
                    }
                }
            }
        }
        
        return liste;
    }


    @Override
    public Volume getJsonVolume(String nomTitre, int numeroVolume) {
        Volume volume = null;
        
        for(Titre t : listeTitres){
            if (t.getNom().equals(nomTitre)){
                for(Volume v : t.getListeVolumes()){
                    if (v.getNumero() == numeroVolume){
                        volume = v;
                    }
                }
            }
            
        }
        
        return volume;
    }

    @Override
    public Titre getJsonTitreParNom(String nom) {
        Titre titre = null;
        
        for (int i = 0; i < listeTitres.size(); i++) { 		
            if (listeTitres.get(i).getNom().equals(nom)){
                titre = listeTitres.get(i);
            }
        }
        
        return titre;
    }

}
