/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

/**
 *
 * @author NervLabs
 */
public class Mensaje {
    int idMensaje;
    String mensaje;
    String autorMensaje;
    String fechaMensjae;
    
    public Mensaje (){
    
}

    public Mensaje(String mensaje, String autorMensaje) {
        this.mensaje = mensaje;
        this.autorMensaje = autorMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutorMensaje() {
        return autorMensaje;
    }

    public void setAutorMensaje(String autorMensaje) {
        this.autorMensaje = autorMensaje;
    }
    
    
}
