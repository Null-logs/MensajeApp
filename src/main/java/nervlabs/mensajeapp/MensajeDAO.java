/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NervLabs
 */
public class MensajeDAO {
    
    public static void crearMensajeDB(Mensaje mensaje){
        
       ConnectionToMysql conexion = ConnectionToMysql.getInstance();
       Connection objetoConexion = conexion.doConnetion();
       
//       conexionDB(conexion);
//       Connection conexion1 = conexion;
       
        PreparedStatement ps = null;
       
        try {
            
            String query = "INSERT INTO Mensaje (cuerpoMensaje, autorMensaje) VALUES (?,?)";
            ps = objetoConexion.prepareStatement(query);
            
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutorMensaje());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"SMS CREADO!!!!");
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            System.exit(0);
        }
       
       
    }
    
    public static void leerMensajeDB() {
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensaje mensaje){
        
    }

}
