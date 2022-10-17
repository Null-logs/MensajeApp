/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author NervLabs
 */
public class ConnectionToMysql {
    
            public Connection get_conection(){
            Connection conection = null;
            try{
                conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajeApp","root","12345");
                if(conection != null){
                    System.out.println("Conexion exitosa con docker nu n");
                }    
            }catch(SQLException e){
                System.out.println(e);
            }
            return conection;
}
}
            
