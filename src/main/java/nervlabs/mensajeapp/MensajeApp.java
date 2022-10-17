/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package nervlabs.mensajeapp;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author NervLabs
 */
public class MensajeApp {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        
        ConnectionToMysql conexion = new ConnectionToMysql();
        
        try(Connection cnx = conexion.get_conection()){
        }catch(Exception e) {
            System.out.println(e);
    }
}
}