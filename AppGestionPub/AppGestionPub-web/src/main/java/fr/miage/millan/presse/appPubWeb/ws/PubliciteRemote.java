/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.appPubWeb.ws;

import fr.miage.millan.presse.appPub.services.ServicePubliciteLocal;
import fr.miage.millan.presse.sharedpubpresse.objects.Publicite;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "PubliciteRemote")
public class PubliciteRemote {

    @EJB
    private ServicePubliciteLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "creerPublicitePourEnvoi")
    @Oneway
    public void creerPublicitePourEnvoi(@WebParam(name = "nomPub") String nomPub, @WebParam(name = "contenu") String contenu) {
        ejbRef.creerPublicitePourEnvoi(nomPub, contenu);
    }

    @WebMethod(operationName = "envoyerPublicites")
    @Oneway
    public void envoyerPublicites() {
        ejbRef.envoyerPublicites();
    }

    @WebMethod(operationName = "getListeEnvoi")
    public ArrayList<Publicite> getListeEnvoi() {
        return ejbRef.getListeEnvoi();
    }
    
}
