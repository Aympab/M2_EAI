/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.appPub.services;

import fr.miage.millan.presse.appPub.jms.SenderPublicite;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author aympa
 */
@Stateless
public class ServicePublicite implements ServicePubliciteLocal {

    SenderPublicite sender = new SenderPublicite();

    public static ArrayList<Publicite> pubsAEnvoyer = new ArrayList<Publicite>();

    @Override
    public void creerPublicitePourEnvoi(String nomPub, String contenu) {
        Publicite pub = new Publicite(nomPub, contenu);
        pubsAEnvoyer.add(pub);
    }

    @Override
    public void envoyerPublicites() {
        try {
            
            sender.sendJMSMessageToPUBINIT(pubsAEnvoyer);
            
        } catch (NamingException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(ServicePublicite.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Vider la liste des pubs à envoyer
        pubsAEnvoyer.clear();

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public ArrayList<Publicite> getListeEnvoi() {
        return pubsAEnvoyer;
    }
}
