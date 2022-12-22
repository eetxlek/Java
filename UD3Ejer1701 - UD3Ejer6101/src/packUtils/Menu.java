
package packUtils;

import app.MenuOpciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static packUtils.UtilString.*;

public class Menu {
    

    public static void Mostrar() throws ClassNotFoundException, SQLException {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario    
        
        while (!salir) {
            Linea();
            System.out.print(Colores.FONDO_BLANCO);
            System.out.println(Colores.LETRA_AZUL + "1. Por sexo");
            System.out.println(Colores.LETRA_AZUL + "2. Por año de nacimiento");
            System.out.println(Colores.LETRA_AZUL + "3. Por dominio");
            System.out.println(Colores.LETRA_AZUL + UtilString.StrRepetir('-',20));
            System.out.println(Colores.LETRA_AZUL + "0. Salir");
            System.out.println(Colores.LETRA_AZUL + UtilString.StrRepetir('-',20));

            try {
                
                System.out.print(Colores.LETRA_NEGRO + "Escribe una de las opciones: ");
                opcion = sn.nextInt();

                Linea();
                switch (opcion) {
                    case 1:
                        MenuOpciones.filtrarSexo();
                        break;  

                    case 2:
                        MenuOpciones.filtrarNac();
                        break;  

                    case 3:
                        MenuOpciones.filtrarDominio();
                        break;  
                        
                    // **************************
                    // SALIR
                    // **************************
                    case 0:
                        salir = true;
                        System.out.println("Terminado");
                        Linea();
                        break;                        
                    default:
                        System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Opción no válida");
                        break;
                }
            } catch (InputMismatchException e) {
                Linea();
                System.out.println(Colores.LETRA_ROJO + Colores.FONDO_AMARILLO + "Debe insertar un número");
                sn.next();
            }
        }               
              
    }
    
    
    
    
}
