/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NervLabs
 */
public class ConnectionToMysql {
    
    //variable que almacena el estado de la conexion de la base de datos
    private static Connection connection;
    
    //variable para crear una sola instancia
    private static ConnectionToMysql instancia;
    
    //variables de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/mensajeApp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public Connection doConnetion (){
        
        try {
            
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            
            JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
            
            return connection;
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Erro: " + e);
             System.exit(0);
        }
        
        return connection;
        
    }

//            Antiguo metodo de conexion    
//            public Connection get_conection(){
//            Connection conection = null;
//            try{
//                conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajeApp","root","12345");
//                if(conection != null){
//                    System.out.println("Conexion exitosa con docker nu n");
//                }    
//            }catch(SQLException e){
//                System.out.println(e);
//            }
//            return conection;
//}
}
            
