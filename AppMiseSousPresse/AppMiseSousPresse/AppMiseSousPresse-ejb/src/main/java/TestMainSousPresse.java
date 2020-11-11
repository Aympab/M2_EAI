
import fr.miage.millan.services.ServicePresse;
import javax.ejb.EJB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aympa
 */
public class TestMainSousPresse {

    @EJB
    static ServicePresse service;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ServicePresse service = new ServicePresse();
        
        service.testReceiver();
    }
    
}
