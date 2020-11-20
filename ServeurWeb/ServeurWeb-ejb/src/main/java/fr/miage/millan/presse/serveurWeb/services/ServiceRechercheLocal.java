/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.services;

import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceRechercheLocal {

    public void getJsonTitre(String nom);
    
}
