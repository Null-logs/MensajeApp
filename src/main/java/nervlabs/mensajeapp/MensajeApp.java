/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NervLabs
 */
public class MensajeApp {

    public static void main(String[] args) throws SQLException {
        
        conexionDB();
        
        menuMensaje();
        

    }
    
    public static void conexionDB() {
         ConnectionToMysql conexion = new ConnectionToMysql();
         
        try(Connection cnx = conexion.doConnetion()){
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void menuMensaje() {
        String [] menuMensaje ={"Nuevo Mensaje","Ver Mensajes","Editar un Mensaje","Eliminar Mensajes", "Salir"}; 
        String opcion = (String) JOptionPane.showInputDialog(null,"Selecciona una opción", "Elegir",JOptionPane.QUESTION_MESSAGE,null,menuMensaje, menuMensaje[0]);
        
        System.out.println(opcion + "=" + menuMensaje[recorrerMenu(menuMensaje, opcion)]);
        
        accionMenuMensaje(recorrerMenu(menuMensaje, opcion));
  
    }

    private static int recorrerMenu(String[] menuMensaje, String opcion) {
        int i = 0;
        int opcionInt = 0;
        while(i != menuMensaje.length){
            if(opcion.equals(menuMensaje[i])){
                opcionInt = i;
            }
            i++;
        }
        
        return opcionInt;
    }

    private static void accionMenuMensaje(int opcionInt) {
        
        switch (opcionInt) {
            case 0 -> MensajeService.crearMensaje();
            case 1 -> MensajeService.listaMensaje();
            case 2 -> MensajeService.editarMensaje();
            case 3 -> MensajeService.borarMensaje();
            default -> System.exit(0);
        }
        
    }
    
}