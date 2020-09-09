/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentregamateriales;

import javax.swing.UIManager;
import ventanas.FramePrincipal;

/**
 *
 * @author LENOVO
 */
public class GestionEntregaMateriales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            for (UIManager.LookAndFeelInfo look : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(look.getName())) {
                    UIManager.setLookAndFeel(look.getClassName());
                }
                
            }
            
        } catch (Exception e) {
        }
        
     (new FramePrincipal()).setVisible(true);
    }
    
}
