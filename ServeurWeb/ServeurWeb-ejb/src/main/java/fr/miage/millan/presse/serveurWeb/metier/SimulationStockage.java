/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.metier;

import fr.miage.millan.presse.sharedvolume.objects.Titre;
import java.util.ArrayList;

/**
 *
 * @author astrid
 */
public final class SimulationStockage {
    
    private static final ArrayList<Titre> titresEnStock = new ArrayList<Titre>();
    
    private static int idTitre = 0;
    
    public static void ajouterVolume(Titre t) {
        t.setId(idTitre);
        idTitre += 1;
        titresEnStock.add(t);
    }
    
    public static ArrayList<Titre> getStockTitre() {
        return titresEnStock;
    }
    
}
