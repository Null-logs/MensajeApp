/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import java.awt.HeadlessException; // en observación
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NervLabs
 */


public class ConnectionToMysql {
    
    private ConnectionToMysql(){
        
    }
    
    
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
            
        } catch (HeadlessException | SQLException e) {
             JOptionPane.showMessageDialog(null,"Erro: " + e);
             System.exit(0);
        }
        
        return connection;
        
    }
    
    
    public void closeConnetion () throws SQLException{
         
         try {
             connection.close();
             JOptionPane.showMessageDialog(null,"DESCONEXIÓN");
             
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Erro: " + e);
             connection.close();
         } finally {
             connection.close();
         }
         
     }
    
    //patron singleton
    public static ConnectionToMysql getInstance(){
        
        if(instancia == null){
            instancia = new ConnectionToMysql ();
        }
        return instancia;
    }
}
