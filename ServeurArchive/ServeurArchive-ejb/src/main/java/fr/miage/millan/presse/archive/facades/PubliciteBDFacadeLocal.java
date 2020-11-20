/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.PubliciteBD;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface PubliciteBDFacadeLocal {

    void create(PubliciteBD publiciteBD);

    void edit(PubliciteBD publiciteBD);

    void remove(PubliciteBD publiciteBD);

    PubliciteBD find(Object id);

    List<PubliciteBD> findAll();

    List<PubliciteBD> findRange(int[] range);

    int count();
    
}
