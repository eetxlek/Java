/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dam.persona;

import java.sql.Connection;
import java.sql.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.Serializable;
import java.util.ArrayList;

public class ListaPersonas implements Serializable {

    ArrayList<Persona> lista = new ArrayList<Persona>();

    public ListaPersonas() {
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "ListaPersonas{" + "lista=" + lista + '}';
    }

    public void cargaSql() throws IOException {
        try {
            lista.clear();

            // Cargar el driver de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Cadena de conexión a MySQL
            String conURL = "jdbc:mysql://localhost:3306/bdpersonas";
            conURL += "?user=root&password=1234";
            conURL += "&useSSL=false&autoReconnect=true&serverTimezone=UTC";
            try ( // Obtener la conexión
                     Connection con = (Connection) DriverManager.getConnection(conURL)) {
                Statement stmt = (Statement) con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * "
                        + "FROM personas, domicilios "
                        + "WHERE personas.dni=domicilios.idpersona");
                while (rs.next()) {
                    Domicilio dom = new Domicilio(rs.getString("direccion"),
                            rs.getString("cpostal"), rs.getString("poblacion"),
                            rs.getString("provincia"));
                    lista.add(new Persona(rs.getInt("dni"),
                            rs.getString("nombre"), rs.getString("apellidos"),
                            rs.getString("telefono"), dom));
                }
                // Cerrar la conexión
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Exception: " + cE.toString());
        }
    }
}
