/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.services;

import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceRechercheLocal {

    public ArrayList<Titre> getJsonTitre();
    
    public Titre getJsonTitreParNom(String nom);

    public ArrayList<Titre> getJsonTitreMotsClefs(String motsClefs);

    public ArrayList<Titre> getJsonTitres();

    public List<Volume> getJsonVolumes(Long idTitre);
    
}
