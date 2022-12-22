/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dam.mavensqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenSQLite {

    public static void main(String[] args) {
          try {
            // Conexión a la BD
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:./datos/bddepartamentos.db";
            String usuario = null;
            String password = null;

            Connection con = DriverManager.getConnection(url, usuario, password);

            // Crear Statement de la Consulta
            String sentenciaSQL = "SELECT dept_no, dnombre, loc FROM departamentos";
            Statement statement = con.createStatement();

            // Resulset
            ResultSet rs = statement.executeQuery(sentenciaSQL);
            System.out.println("+----+-----------------+-----------------+");
            System.out.println("| DP | Nombre          | Loc             |");
            System.out.println("+----+-----------------+-----------------+");
            while (rs.next()) {
                System.out.printf("| %2d |", rs.getInt("dept_no"));
                System.out.printf(" %-15s |", rs.getString("dnombre"));
                System.out.printf(" %-15s |", rs.getString("loc"));
                System.out.println();
            }
            rs.close();
            System.out.println("+----+-----------------+-----------------+");

            // Cerrar conexión
            con.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Excepción: " + cE.toString());
        }
    }
}
