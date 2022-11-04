/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nervlabs.mensajeapp;

import com.mysql.cj.xdevapi.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public static DefaultTableModel leerMensajeDB() {
        
       ConnectionToMysql conexion = ConnectionToMysql.getInstance();
       Connection objetoConexion = conexion.doConnetion();
       
       PreparedStatement ps = null;
       ResultSet rs = null;
       ResultSetMetaData metaDatos = null;
       
        try {
            
            String query = "SELECT * FROM Mensaje m";
            ps = objetoConexion.prepareStatement(query);
            rs = ps.executeQuery();
            metaDatos = rs.getMetaData();
            
            return crearModeloTabla(rs, metaDatos);
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudieron Extraer los datos" + e);
            System.exit(0);
        }
        
        return null;
    }
      
    
    public static void borrarMensajeDB(int id_mensaje){
        
    }
    
    public static void actualizarMensajeDB(Mensaje mensaje){
        
    }
    
    public static DefaultTableModel crearModeloTabla(ResultSet rs, ResultSetMetaData metaDatos) throws SQLException{
        
        DefaultTableModel modelo = new DefaultTableModel();

        // Se obtiene el número de columnas.
        int numeroColumnas = metaDatos.getColumnCount();
        
        // Se crea un array de etiquetas para rellenar
        Object[] etiquetas = new Object[numeroColumnas];

        // Se obtiene cada una de las etiquetas para cada columna
        for (int i = 0; i < numeroColumnas; i++)
        {
           // Nuevamente, para ResultSetMetaData la primera columna es la 1.
           etiquetas[i] = metaDatos.getColumnLabel(i + 1);
        }
          
        modelo.setColumnIdentifiers(etiquetas);
        
        // Bucle para cada resultado en la consulta
        while (rs.next())
        {
           // Se crea un array que será una de las filas de la tabla.
           Object [] fila = new Object[numeroColumnas]; // Hay tres columnas en la tabla

           // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
           for (int i=0;i<numeroColumnas;i++)
              fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

           // Se añade al modelo la fila completa.
           modelo.addRow(fila);
        }
        
//        System.out.println(modelo);
//        
//        JTable tabla = new JTable(modelo);
//        JScrollPane scrollPane = new JScrollPane(tabla);
//        tabla.setFillsViewportHeight(true);
//        
//        tabla.setVisible(true);
//        

        return modelo;
    }

}
