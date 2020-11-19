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
public interface VolumeFacadeLocal {

    void create(VolumeBD volume);

    void edit(VolumeBD volume);

    void remove(VolumeBD volume);

    VolumeBD find(Object id);

    List<VolumeBD> findAll();

    List<VolumeBD> findRange(int[] range);

    int count();
    
}
