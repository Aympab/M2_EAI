/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.distributeur.ws;

import fr.miage.millan.presse.distributeur.ServiceDistributeurLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "WSDistrib")
@Stateless()
public class WSDistrib {

    @EJB
    private ServiceDistributeurLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createAndSendContrat")
    @Oneway
    public void createAndSendContrat() {
        ejbRef.createAndSendContrat();
    }
    
}
