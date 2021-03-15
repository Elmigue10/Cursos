package CRUD_MySQL_MVC;

import Controlador.controllerCustomer;
import Modelo.Customer;
import Modelo.consultasCustomer;
import Vista.formCustomer;

/**
 *
 * @author Miguel
 */
public class Crud_MySQL_MVC {
    
    public static void main (String [] args) {
    
        Customer mod = new Customer();
        consultasCustomer modC = new consultasCustomer();
        formCustomer form = new formCustomer();
        
        controllerCustomer controller = new controllerCustomer (mod, modC, form);
     
        controller.iniciar();
        form.setVisible(true);
        
    }
    
}
