/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.Volume;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface VolumeFacadeLocal {

    void create(Volume volume);

    void edit(Volume volume);

    void remove(Volume volume);

    Volume find(Object id);

    List<Volume> findAll();

    List<Volume> findRange(int[] range);

    int count();
    
}
