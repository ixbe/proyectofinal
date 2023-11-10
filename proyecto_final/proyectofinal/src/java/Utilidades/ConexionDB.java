/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author _mrodriguezb
 */
public class ConexionDB {
 
    public static Connection getConexion() {
        Connection cnx = null;
        try {
          //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           // cnx = DriverManager.getConnection("jdbc:sqlserver://MARB:1433;databaseName=BD_CitasMedicas;user:sa;password=cenizo");
        	
        	Class.forName("com.mysql.jdbc.Driver");
        	cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdproductos","root","");
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(""+e.toString());
        }
        return cnx;
    }
//    public static void main(String[] args) {
//        Connection conexion = getConexion();
//        if (conexion != null) {
//            System.out.println("¡Conexión exitosa!");
//            try {
//                // Aquí puedes realizar más operaciones con la conexión si es necesario
//                conexion.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexión: " + e.toString());
//            }
//        } else {
//            System.out.println("Error al conectar a la base de datos.");
//        }
//    }
    
}
