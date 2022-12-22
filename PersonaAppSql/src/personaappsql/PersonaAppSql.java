/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package personaappsql;

import com.dam.persona.ListaPersonas;
import java.io.IOException;


public class PersonaAppSql {

    public static void main(String[] args) throws IOException {
        ListaPersonas lista = new ListaPersonas();
        lista.cargaSql();

        for (int i = 0; i < lista.getLista().size(); i++) {
            System.out.println(lista.getLista().get(i).toString());
        }

    }

}
