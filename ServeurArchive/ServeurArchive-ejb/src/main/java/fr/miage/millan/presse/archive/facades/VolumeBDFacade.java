/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.facades;

import fr.miage.millan.presse.archive.entities.VolumeBD;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aympa
 */
@Stateless
public class VolumeBDFacade extends AbstractFacade<VolumeBD> implements VolumeBDFacadeLocal {

    @PersistenceContext(unitName = "fr.miage.millan_ServeurArchive-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VolumeBDFacade() {
        super(VolumeBD.class);
    }
    
}
