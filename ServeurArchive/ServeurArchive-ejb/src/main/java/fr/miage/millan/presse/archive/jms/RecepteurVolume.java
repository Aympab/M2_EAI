/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.jms;

import fr.miage.millan.presse.archive.business.ServiceArchivage;
import fr.miage.millan.presse.archive.business.ServiceArchivageLocal;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "PRESSE_TRANSFERT_ARCHIVE", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecepteurVolume implements MessageListener {

    @EJB
    private ServiceArchivageLocal serviceArchivage;

//    @EJB
//    private ServiceArchivage serviceArchivage;// = new ServiceArchivage();
    @Override
    public void onMessage(Message message) {
//        System.out.println("APPARCHIVE - OnMessage, OBJ : " + message);
        System.out.println("SALUT");
        if (message instanceof ObjectMessage) {
            System.out.println("SALUT OBJECT MESSAGE");

            ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Titre> titres = (ArrayList<Titre>) object.getObject();

                //APPEL METIER  
                try {
                    serviceArchivage.traiterReceptionTitres(titres);

                } catch (Exception e) {
                    System.out.println("EXCEPTION SERVICE ARCHIVAGE !!!!!");
                }

            } catch (Exception e) {
                System.out.println("APPARCHIVE ERREUR " + e.getMessage());
//                Logger.getLogger(RecepteurVolume.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (message != null) {
            System.out.println("APPARCHIVE - Object type is not ObjectMessage");
        }
    }
}
