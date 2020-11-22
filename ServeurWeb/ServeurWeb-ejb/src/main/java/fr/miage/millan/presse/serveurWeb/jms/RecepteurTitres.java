/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.serveurWeb.jms;

import fr.miage.millan.presse.serveurWeb.metier.SimulationStockage;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "ARCHIVE_TRANSFERT_SRVWEB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecepteurTitres implements MessageListener {

    public RecepteurTitres() {
    }

    @Override
    public void onMessage(Message message) {
        //Stocker les titres dans la simulation
        System.out.println("SERVEUR WEB - Message reçu");
        if (message instanceof ObjectMessage) {
            ObjectMessage object = (ObjectMessage) message;

            try {
                ArrayList<Titre> titres = (ArrayList<Titre>) object.getObject();

                //APPEL METIER  
                SimulationStockage.receptionnerTitres(titres);

            } catch (Exception e) {
                System.out.println("APPARCHIVE ERREUR " + e.getMessage());
                Logger.getLogger(RecepteurTitres.class.getName()).log(Level.SEVERE, null, e);
            }
        } else if (message != null) {
            System.out.println("APPARCHIVE - Object type is not ObjectMessage");
        }
    }

}
