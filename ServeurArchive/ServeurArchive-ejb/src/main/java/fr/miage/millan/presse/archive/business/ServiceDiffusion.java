/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.business;

import fr.miage.millan.presse.archive.entities.TitreBD;
import fr.miage.millan.presse.archive.facades.TitreBDFacadeLocal;
import fr.miage.millan.presse.archive.jms.SenderTitres;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServiceDiffusion implements ServiceDiffusionLocal {

    @EJB
    private TitreBDFacadeLocal titreBDFacade;

    private final SenderTitres sender = new SenderTitres();

    @Override
    public String diffuserTitresVersServeurRecherche() {
        try {

            ArrayList<TitreBD> titresBD = new ArrayList<>(titreBDFacade.findAll());

            ArrayList<Titre> titres = GestionEntity.genererTitres(titresBD);

            sender.sendJMSMessageToARCHIVE_TRANSFERT_SRVWEB(titres);

            return "OK";

        } catch (JMSException ex) {
            Logger.getLogger(ServiceDiffusion.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        } catch (NamingException ex) {
            Logger.getLogger(ServiceDiffusion.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR";
        }
    }

}
