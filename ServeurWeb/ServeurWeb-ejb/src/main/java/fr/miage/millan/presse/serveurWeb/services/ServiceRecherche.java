/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.services;

import fr.miage.millan.presse.serveurWeb.metier.SimulationStockage;
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
    public Titre getJsonTitreMotsClefs(List<String> motsClefs) {
        //Salut Astrid;
        return new Titre();
    }

    @Override
    public ArrayList<Titre> getJsonTitres() {
        //Salut Astrid;
        return new ArrayList<Titre>();
    }

    @Override
    public List<Volume> getJsonVolumes(Long idTitre) {
        //Salut Astrid;
        return new ArrayList<Volume>();
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
