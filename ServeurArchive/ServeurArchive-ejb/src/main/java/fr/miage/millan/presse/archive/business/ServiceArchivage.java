/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.TitreBD;
import fr.miage.millan.presse.archive.entities.VolumeBD;
import fr.miage.millan.presse.archive.facades.TitreBDFacadeLocal;
import fr.miage.millan.presse.archive.facades.VolumeBDFacadeLocal;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceArchivage implements ServiceArchivageLocal {

    @EJB
    private TitreBDFacadeLocal titreBDFacade;
    
    @EJB
    private VolumeBDFacadeLocal volumeFacade;
    
//    @Override
    public VolumeBD sauvegarderVolume(Volume v) {
        VolumeBD vol = GestionEntity.genererVolumeBD(v);
                
        volumeFacade.create(vol);
        
        return vol;
    }

    @Override
    public void traiterReceptionVolumes(ArrayList<Volume> volumes) {
        for(Volume v : volumes){
            System.out.println("APPARCHIVE - Enregistrement volume " + v.toString());
            this.sauvegarderVolume(v);
        }
    }

    @Override
    public void traiterReceptionTitres(ArrayList<Titre> titres) {
        for(Titre t : titres){
            System.out.println("APPARCHIVE - Enregistrement titre" + t.toString());
            TitreBD titre = GestionEntity.genererTitreBD(t);
            
            titreBDFacade.create(titre);
        }
    }

}
