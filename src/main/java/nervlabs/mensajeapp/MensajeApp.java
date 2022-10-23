/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author NervLabs
 */
public class MensajeApp {

    public static void main(String[] args) throws SQLException {
        
        
        Scanner sc = new Scanner(System.in);
       
        String [] menuMensaje ={"Nuevo Mensaje","Ver Mensajes","Editar un Mensaje","Eliminar Mensajes", "Salir"}; 
        String opcion = (String) JOptionPane.showInputDialog(null,"Selecciona una opción", "Elegir",JOptionPane.QUESTION_MESSAGE,null,menuMensaje, menuMensaje[0]);
        
        System.out.println();
        
        ConnectionToMysql conexion = new ConnectionToMysql();
        
        try(Connection cnx = conexion.get_conection()){
        }catch(Exception e) {
            System.out.println(e);
        }
        
    }
    
}