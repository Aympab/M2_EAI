/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distributeur.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author aympa
 */
@MessageDriven(mappedName = "DIFFUSION_DISTRIB", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "DIFFUSION_DISTRIB")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "DIFFUSION_DISTRIB")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class RecepteurTitresDistrib implements MessageListener {
    
    public RecepteurTitresDistrib() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("DISTRIBUTEUR - Titres reçus");
    }
    
}
