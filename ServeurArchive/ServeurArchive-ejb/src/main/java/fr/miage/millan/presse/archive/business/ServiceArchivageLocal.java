/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import javax.ejb.Local;

/**
 *
 * @author aympa
 */
@Local
public interface ServiceArchivageLocal {
    public VolumeBD transformerVolumeEnEntity(Volume v);
}
