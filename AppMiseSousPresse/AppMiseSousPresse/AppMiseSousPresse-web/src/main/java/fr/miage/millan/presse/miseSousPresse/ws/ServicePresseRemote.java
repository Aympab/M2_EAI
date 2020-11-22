/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.millan.presse.miseSousPresse.ws;

import fr.miage.millan.presse.miseSousPresse.services.ServicePresseLocal;
import fr.miage.millan.presse.sharedvolume.objects.Titre;
import fr.miage.millan.presse.sharedvolume.objects.Volume;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author aympa
 */
@WebService(serviceName = "ServicePresseRemote")
@Stateless()
public class ServicePresseRemote {

    @EJB
    private ServicePresseLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "notifierAppRedac")
    @Oneway
    public void notifierAppRedac() {
        ejbRef.notifierAppRedac();
    }

    @WebMethod(operationName = "getVolumesAEnvoyer")
    public ArrayList<Volume> getVolumesAEnvoyer() {
        return ejbRef.getVolumesAEnvoyer();
    }

    @WebMethod(operationName = "transfererVolumesArchive")
    @Oneway
    public void transfererVolumesArchive() {
        ejbRef.transfererVolumesArchive();
    }

    @WebMethod(operationName = "transfererVolumesDistribution")
    @Oneway
    public void transfererVolumesDistribution() {
        ejbRef.transfererVolumesDistribution();
    }

    @WebMethod(operationName = "selectionnerVolumePourEnvoi")
    public ArrayList<Volume> selectionnerVolumePourEnvoi(@WebParam(name = "idVolume") int idVolume) {
        return ejbRef.selectionnerVolumePourEnvoi(idVolume);
    }

    @WebMethod(operationName = "printAllStock")
    @Oneway
    public void printAllStock() {
        ejbRef.printAllStock();
    }

    @WebMethod(operationName = "transfererTitresArchive")
    @Oneway
    public void transfererTitresArchive() {
        ejbRef.transfererTitresArchive();
    }

    @WebMethod(operationName = "selectionnerTitrePourEnvoi")
    public ArrayList<Titre> selectionnerTitrePourEnvoi(@WebParam(name = "idTitre") int idTitre) {
        return ejbRef.selectionnerTitrePourEnvoi(idTitre);
    }

    @WebMethod(operationName = "diffuserTitres")
    public String diffuserTitres() {
        return ejbRef.diffuserTitres();
    }
    
}
