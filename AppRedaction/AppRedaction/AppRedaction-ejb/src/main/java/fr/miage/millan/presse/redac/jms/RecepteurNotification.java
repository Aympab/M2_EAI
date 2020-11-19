/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.redac.jms;

import fr.miage.millan.presse.redac.services.ServiceRedaction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "PRESSE_NOTIF_REDAC", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecepteurNotification implements MessageListener {

    ServiceRedaction metier;

    public RecepteurNotification() {
        metier = new ServiceRedaction();
    }

    @Override
    public void onMessage(Message message) {
        
//        this.metier.traiterNotification();
        
        if (message instanceof ObjectMessage) {
            ObjectMessage object = (ObjectMessage) message;

            try {
                String notif = (String) object.getObject();

                this.metier.traiterNotification(notif);

            } catch (JMSException ex) {
                Logger.getLogger(RecepteurNotification.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (message != null) {
            System.out.println("APPREDACTION - The message is not a type ObjectMessage.\n\tObject : " + message.toString());
        }
    }

}
