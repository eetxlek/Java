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
        String usuario = "usuejer";
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
        String sentenciaSQL = "SELECT NOMBRE, APELLIDOS FROM ACCESOS WHERE SEXO='"+sexo+"' ORDER BY NOMBRE";

        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+-----------------+-----------------+\n");
        System.out.print("| NOMBRE          | APELLIDOS       |\n");
        System.out.print("+-----------------+-----------------+\n");
        while (rs.next()) {
        
        System.out.printf("| %15S | %-15s |\n", rs.getString(1), rs.getString(2));}
        rs.close();
        System.out.print("+-----------------+-----------------+\n");

    }

    public static void filtrarNac() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);

        // Pedir datos
        System.out.print("Indique el año a filtrar: ");
        String year = teclado.nextLine();

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT NOMBRE, APELLIDOS, FECHA_NAC FROM ACCESOS WHERE EXTRACT(YEAR FROM FECHA_NAC)="+year+" ORDER BY NOMBRE";
        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+-----------------+-----------------+-------------+\n");
        System.out.print("| NOMBRE          | APELLIDOS       | NACIMIENTO  |\n");
        System.out.print("+-----------------+-----------------+-------------+\n");
        while (rs.next()) {

            System.out.printf("| %15S | %-15s | %-10s |\n", rs.getString(1), rs.getString(2), rs.getDate(3));
           
        }
        rs.close();
        System.out.print("+-----------------+-----------------+--------------+\n");

    }

    public static void filtrarDominio() throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);

        // Pedir datos
        System.out.print("Indique el dominio a filtrar: ");
        String dominio = teclado.nextLine();

        // Crear Statement de la Consulta
        String sentenciaSQL = "SELECT NOMBRE, APELLIDOS,EMAIL FROM ACCESOS WHERE EMAIL LIKE '%"+dominio+"' ORDER BY NOMBRE";
        Statement statement = con.createStatement();

        // Resulset
        ResultSet rs = statement.executeQuery(sentenciaSQL);
        System.out.print("+-----------------+-----------------+--------------------------------+\n");
        System.out.print("| NOMBRE          | APELLIDOS       | EMAIL                          |\n");
        System.out.print("+-----------------+-----------------+--------------------------------+\n");
        while (rs.next()) {
            
              System.out.printf("| %15S | %-15s | %-30s |\n", rs.getString(1), rs.getString(2), rs.getString(3));
         
        }
        rs.close();
        System.out.print("+-----------------+-----------------+--------------------------------+\n");

    }

}
