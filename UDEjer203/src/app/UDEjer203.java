/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UDEjer203 {
  
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         // Cargar el driver de mysql antes de acceder a BD
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Cadena de conexión a MySQL
         String conURL = "jdbc:mysql://localhost?user=root&password=admin&useSSL=false&serverTimezone=UTC";

         try
         // Establecer la conexión
         (Connection con = DriverManager.getConnection(conURL)){
         
         //crea statement desde conexion
         Statement stmt = con.createStatement();
         ResultSet rsAlterarTabla = stmt.executeQuery("use badpps; ALTER TABLE programas ADD ocupacion INT DEFAULT 0;");
         
         con.close();
    }  catch (SQLException se) {
            System.out.println(se.getErrorCode() + " " + se.getMessage());
        }
    }
}
