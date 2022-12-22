package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SwingDinamico {

    public static void main(String[] args) {

        // CREAR CARPETA DATOS SI NO EXISTE
        boolean crearDatos=true;
        File datos = new File("./datos/");
        if (datos.exists()) {
            if (datos.isDirectory()) {
                crearDatos=false;
            }
        }
        if (crearDatos) datos.mkdir();
        
        
        // CREAR ARCHIVO DE TEXTO
        String archivo = JOptionPane.showInputDialog("Introduce el nombre de un archivo: ");
        if (!archivo.isEmpty()) {
            try ( PrintWriter fichero = new PrintWriter("./datos/" + archivo + ".txt", StandardCharsets.UTF_8)) {
                fichero.println("Creado desde la aplicación de escritorio de tipo Window");

                JOptionPane.showMessageDialog(null, "Archivo creado");

            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al crear el archivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de archivo no puede ser vacío");
        }
    }
}
