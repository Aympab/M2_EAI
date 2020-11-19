/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import javax.ejb.Stateless;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceArchivage implements ServiceArchivageLocal {

    @Override
    public VolumeBD transformerVolumeEnEntity(Volume v) {
//        genererPublicitesEnBd(v.getListePublicites());
//        genererArticlesEnBd(v.getListeArticles());
        
        return null;
    }

}
