/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NervLabs
 */
public class MensajeService {
    
    public static void crearMensaje(){
        System.out.println("public static void crearMensaje()");
        
        Mensaje tuplaNueva = new Mensaje();
//        
//        String nombre="";
//        nombre=JOptionPane.showInputDialog("Escribe tu nombre");
//        
        tuplaNueva.setAutorMensaje(JOptionPane.showInputDialog("Escribe tu nombre"));
        tuplaNueva.setMensaje(JOptionPane.showInputDialog("Escribe tu mensaje"));
        
        MensajeDAO.crearMensajeDB(tuplaNueva);
    }
    
    public static DefaultTableModel listaMensaje(){
        System.out.println("public static void listaMensaje()");
        return MensajeDAO.leerMensajeDB();
    }
 
    public static void borarMensaje(){
        System.out.println("public static void borarMensaje()");
    }
    
    public static void editarMensaje(){
        System.out.println("public static void editarMensaje()");
    }
}
