/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.jms;

import fr.miage.millan.presse.miseSousPresse.services.ServicePresse;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import java.util.ArrayList;
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
@MessageDriven(mappedName = "PUBINIT", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecepteurPub implements MessageListener {

    private ServicePresse metier;

    public RecepteurPub() {
        metier = new ServicePresse();
    }

    @Override
    public void onMessage(Message message) {
//        System.out.println("APPGESTIONPUB - MESSAGE RECU");

        if (message instanceof ObjectMessage) {
            ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Publicite> a = (ArrayList<Publicite>) object.getObject();

                //APPEL METIER                
                metier.recupererPub(a);

            } catch (JMSException ex) {
                Logger.getLogger(RecepteurArticle.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (message != null) {
            System.out.println("APPGESTIONPUB - Object type is not ObjectMessage");
        }

    }

}
