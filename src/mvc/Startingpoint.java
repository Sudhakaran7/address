/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import javax.swing.SwingUtilities;
import mvc.controller.AddressBookController;


/**
 *
 * @author Bharathy Annamalai KGiSL
 */
public class Startingpoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            
   

            @Override
            public void run() {
               
                AddressBookController controller=new AddressBookController();
                controller.control();
               
            }
        });
    }
}
