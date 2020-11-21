/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.ws;

import fr.miage.millan.presse.miseSousPresse.services.AssemblageVolLocal;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author igouane
 */
@WebService(serviceName = "ServiceAssemblageRem")
@Stateless()
public class ServiceAssemblageRem {

    @EJB
    private AssemblageVolLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "assemblerVolumeSimple")
    public Volume assemblerVolumeSimple(@WebParam(name = "numeroVolume") int numeroVolume) throws Exception {
        return ejbRef.assemblerVolumeSimple(numeroVolume);
    }

    @WebMethod(operationName = "assemblerTitreSimple")
    public Titre assemblerTitreSimple(@WebParam(name = "nomTitre") String nomTitre) throws Exception {
        return ejbRef.assemblerTitreSimple(nomTitre);
    }

    @WebMethod(operationName = "assemblerVolumeComplexe")
    public Volume assemblerVolumeComplexe(@WebParam(name = "numeroVolume") int numeroVolume, @WebParam(name = "listeIdsArticles") ArrayList<Integer> listeIdsArticles, @WebParam(name = "listeIdsPubs") ArrayList<Integer> listeIdsPubs) throws Exception {
        return ejbRef.assemblerVolumeComplexe(numeroVolume, listeIdsArticles, listeIdsPubs);
    }
    
}
