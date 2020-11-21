/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface AssemblageVolLocal {
    
    public Volume assemblerVolumeSimple(int numeroVolume) throws Exception ;
    
    public Titre assemblerTitreSimple(String nomTitre) throws Exception;
     */
     * @throws Exception 
     * @return
     * @param nomTitre
     * Genere un titre avec tous les volumes présents en BD
    /**
    
    /**
     *Permet de créer un volume en sélectionnant des articles et pubs dans le stockage
     * @param numeroVolume
     * @param listeIdsArticles
     * @param listeIdsPubs
     * @return
     */
    public Volume assemblerVolumeComplexe(int numeroVolume, ArrayList<Integer> listeIdsArticles, ArrayList<Integer> listeIdsPubs)  throws Exception;
}
