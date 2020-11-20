/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceArchivageLocal {
    //public VolumeBD sauvegarderVolume(Volume v);
    
    /**
     * Va gérer les volumes lorsqu'on recoit depuis la queue JMS
     * @param volumes 
     */
    public void traiterReceptionVolumes(ArrayList<Volume> volumes);
    
}
