/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.services;

import fr.miage.millan.presse.miseSousPresse.metier.SimulationStockage;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import javax.ejb.Stateless;

/**
 *
 * @author aympa
 */
@Stateless
public class AssemblageVol implements AssemblageVolLocal {

    @Override
    public Volume assemblerVolumeSimple() throws Exception {

        Volume volume = new Volume();

        if (SimulationStockage.getStockArticle().size() > 0) {
            volume.setListeArticles(SimulationStockage.getStockArticle());
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas d'articles en stock pour assembler un volume");
        }

        if (SimulationStockage.getStockPub().size() > 0) {
            volume.setListePublicites(SimulationStockage.getStockPub());
        } else {
            throw new Exception("APPPRESSE - ERREUR AssemblageVol - Pas de publicites en stock pour assembler un volume");
        }

        volume.setNumero(1);
        
        sauvegarderVolume(volume);
        return volume;
    }

    public void sauvegarderVolume(Volume v) {
        SimulationStockage.ajouterVolume(v);
    }
}
