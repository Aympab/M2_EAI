/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.jms;

import fr.miage.millan.presse.archive.business.ServiceArchivage;
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
    private ServiceArchivage serviceArchivage;

    public RecepteurVolume() {
    }

    @Override
    public void onMessage(Message message) {
//        System.out.println("APPARCHIVE - OnMessage, OBJ : " + message);

        if (message instanceof ObjectMessage) {
            ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Volume> vols = (ArrayList<Volume>) object.getObject();

                //APPEL METIER                
                serviceArchivage.traiterReceptionVolumes(vols);

            } catch (JMSException ex) {
                Logger.getLogger(RecepteurVolume.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (message != null) {
            System.out.println("APPARCHIVE - Object type is not ObjectMessage");
        }
    }
}
