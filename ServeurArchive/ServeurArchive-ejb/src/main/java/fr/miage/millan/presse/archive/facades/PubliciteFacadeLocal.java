/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.Publicite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface PubliciteFacadeLocal {

    void create(Publicite publicite);

    void edit(Publicite publicite);

    void remove(Publicite publicite);

    Publicite find(Object id);

    List<Publicite> findAll();

    List<Publicite> findRange(int[] range);

    int count();
    
}
