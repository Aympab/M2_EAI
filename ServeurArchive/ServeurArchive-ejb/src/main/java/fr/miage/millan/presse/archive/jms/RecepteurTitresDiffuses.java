/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.jms;

import fr.miage.millan.presse.archive.business.ServiceArchivageLocal;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "DIFFUSION_TITRES", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "DIFFUSION_TITRES")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "DIFFUSION_TITRES")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class RecepteurTitresDiffuses implements MessageListener {

    public RecepteurTitresDiffuses() {
    }

    @EJB
    private ServiceArchivageLocal serviceArchivage;

    @Override
    public void onMessage(Message message) {
        System.out.println("SERVEUR ARCHIVE : Diffusion reçue");
        if (message instanceof ObjectMessage) {
            ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Titre> titres = (ArrayList<Titre>) object.getObject();

                //APPEL METIER  
                serviceArchivage.traiterReceptionTitres(titres);

            } catch (Exception e) {
                System.out.println("APPARCHIVE ERREUR " + e.getMessage());
                Logger.getLogger(RecepteurVolume.class.getName()).log(Level.SEVERE, null, e);
            }
        } else if (message != null) {
            System.out.println("APPARCHIVE - Object type is not ObjectMessage");
        }
    }

}
