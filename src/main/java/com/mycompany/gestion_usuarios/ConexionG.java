    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author accpm
 */
public class ConexionG {
    
    Connection conectar = null;
    
    String usuario = "root";
    String contrasenia = "";
    String bd = "GIMNASIO";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos" + e.toString());
        }
        return conectar;
    }   
}
