package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MenuOpciones {

    private static Connection con;

    public static void conectarOracle() throws ClassNotFoundException, SQLException {
        // Selecionar y cargar el Driver en Memoria
        Class.forName("oracle.jdbc.OracleDriver");

        // Establecer la conexion con la BD
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "usuejer"
                + "";
        String password = "1234";
        con = DriverManager.getConnection(url, usuario, password);
    }

    public static void desconectarOracle() throws SQLException {
        // Cerrar conexión
        con.close();
    }

    public static void filtrarSexo() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);

        // Pedir datos
        System.out.print("Indique el sexo a filtrar: ");
        String sexo = teclado.nextLine();

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT NOMBRE, APELLIDOS FROM ACCESOSLOG WHERE SEXO="+ sexo;

        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+--------------------------------+--------------------------------+\n");
        System.out.print("| NOMBRE                         | APELLIDOS                      |\n");
        System.out.print("+--------------------------------+--------------------------------+\n");
        while (rs.next()) {

            
            
        }
        rs.close();
        System.out.print("+--------------------------------+--------------------------------+\n");

    }

    public static void filtrarNac() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);

        // Pedir datos
        System.out.print("Indique el año a filtrar: ");
        String year = teclado.nextLine();

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT * FROM ACCESOS";
        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+--------------------------------+--------------------------------+------------+\n");
        System.out.print("| NOMBRE                         | APELLIDOS                      | NACIMIENTO |\n");
        System.out.print("+--------------------------------+--------------------------------+------------+\n");
        while (rs.next()) {



        }
        rs.close();
        System.out.print("+--------------------------------+--------------------------------+------------+\n");

    }

    public static void filtrarDominio() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);

        // Pedir datos
        System.out.print("Indique el dominio a filtrar: ");
        String dominio = teclado.nextLine();

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT * FROM ACCESOS";
        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+--------------------------------+--------------------------------+--------------------------------+\n");
        System.out.print("| NOMBRE                         | APELLIDOS                      | EMAIL                          |\n");
        System.out.print("+--------------------------------+--------------------------------+--------------------------------+\n");
        while (rs.next()) {
            
            
            
            
        }
        rs.close();
        System.out.print("+--------------------------------+--------------------------------+--------------------------------+\n");

    }

}
