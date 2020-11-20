/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.TitreBD;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface TitreBDFacadeLocal {

    void create(TitreBD titreBD);

    void edit(TitreBD titreBD);

    void remove(TitreBD titreBD);

    TitreBD find(Object id);

    List<TitreBD> findAll();

    List<TitreBD> findRange(int[] range);

    int count();
    
}
