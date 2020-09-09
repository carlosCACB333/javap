/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author LENOVO
 */
public class conexion {

    public static Connection Conectar() {
        Connection conec = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_materiales", "root", "mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conec;
    }
    
    
       

}
