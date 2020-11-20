/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.VolumeBD;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface VolumeBDFacadeLocal {

    void create(VolumeBD volumeBD);

    void edit(VolumeBD volumeBD);

    void remove(VolumeBD volumeBD);

    VolumeBD find(Object id);

    List<VolumeBD> findAll();

    List<VolumeBD> findRange(int[] range);

    int count();
    
}
