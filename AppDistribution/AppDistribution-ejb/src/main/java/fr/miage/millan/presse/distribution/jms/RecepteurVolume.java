/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distribution.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "PRESSE_TRANSFERT_DISTRIB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecepteurVolume implements MessageListener {
    
    public RecepteurVolume() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        //Send notification aux abonnés avec les nouveaux titres
    }
    
}
