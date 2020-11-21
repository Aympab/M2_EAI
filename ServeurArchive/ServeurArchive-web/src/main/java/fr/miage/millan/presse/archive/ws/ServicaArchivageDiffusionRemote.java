/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.archive.ws;

import fr.miage.millan.presse.archive.business.ServiceDiffusionLocal;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "ServicaArchivageDiffusionRemote")
@Stateless()
public class ServicaArchivageDiffusionRemote {

    @EJB
    private ServiceDiffusionLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "diffuserTitresVersServeurRecherche")
    public String diffuserTitresVersServeurRecherche() {
        return ejbRef.diffuserTitresVersServeurRecherche();
    }
    
}
