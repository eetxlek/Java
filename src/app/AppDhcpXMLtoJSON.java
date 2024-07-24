/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Dispositivo;
import clases.Extras;
import clases.serdhcp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author eetxa
 */
public class AppDhcpXMLtoJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        serdhcp se = new serdhcp();
        
        try {
            //CARGAR CONS ANOTACIONES DE JAXB el file xml en objetos.
            // Unmarshaller de xml a serdhcp de dispositivos // mapeo de xml a objetos
            JAXBContext context = JAXBContext.newInstance(serdhcp.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            se = (serdhcp) unmarshaller.unmarshal(new File("./datos/dhcp.xml"));
            
        } catch (JAXBException ex) {
            Logger.getLogger(AppDhcpXMLtoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        //MOSTRAR cada objeto

        ArrayList<Dispositivo> disps = se.getDispositivos(); //vuelca todo
        ArrayList<Dispositivo> wds = new ArrayList<>(); // para cargar los ws

        System.out.println(" DATOS DE DISPOSITIVOS DEL SERVIDOR DHCP\n");
        System.out.println(" =======================================");
        
        
        for (Dispositivo d : disps) {
            System.out.println("Código.........: " + d.getCodigo());
            System.out.println("Marca..........: " + d.getMarca());
            System.out.println("Sist. Operativo: " + d.getSisope());
            //cargar array con los disp windows
            if (d.getSisope().equals("Windows")) {
                wds.add(d);
            }
            System.out.println("RAM (GB).......: " + d.getRamgb());
            System.out.println("HD(GB).........: " + d.getHdgb());
            String dvd = "";
            if (d.getExtras().isDvd() == true) {
                dvd = "SI";
            } else if (d.getExtras().isDvd() == false) {
                dvd = "NO";
            }
            System.out.println("DVD............: " + dvd);
            String lector = "";
            if (d.getExtras().isLector_tarjetas() == true) {
                lector = "SI";
            } else if (d.getExtras().isLector_tarjetas() == false) {
                lector = "NO";
            }
            System.out.println("lector tarjetas: " + lector);
            System.out.println("Vídeo..........: " + d.getExtras().getVideo());
            System.out.println("Usuarios.......: " + d.getUsuarios());
            System.out.println(" ---------------------------------------");
        }

        //crea archivo json, mostrando ademas el resultado por pantalla
        // gson para mostrar por pantalla y jabax.json para crear el json file
        // MOSTRAR EL OBJETO JSON en String usando gson con gsonBuilder y arrayWindows
        System.out.println("DATOS  CONVERTIDOS A JSON");
        System.out.println("=========================");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String listaObjetos = gson.toJson(wds);
        System.out.println(listaObjetos);

        //AHORA CREAR EL OBJETO JSON. JsonArray+JsonObj recorre añadiendo objetos Json
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        for (Dispositivo d : wds) {

            //crea objeto y añase los atributos
            JsonObjectBuilder jsonObj = Json.createObjectBuilder();
            jsonObj.add("Codigo", d.getCodigo());
            jsonObj.add("Marca", d.getMarca());
            jsonObj.add("sisope", d.getSisope());
            for (String u : d.getUsuarios()) {
                jsonObj.add("usuario", u);
            }
            Extras e = d.getExtras();
            jsonObj.add("dvd", e.isDvd());
            jsonObj.add("lector_tarjetas",e.isLector_tarjetas());
            jsonObj.add("video", e.getVideo());
            jsonObj.add("ramgb", d.getRamgb());
            jsonObj.add("hdgb", d.getHdgb());

            //añade obj a array
            jsonArray.add(jsonObj);
            
        }
         JsonArray arrayJ = jsonArray.build();// CREA el objeto en formato json

        //ESCRIBIR EL obj JSON EN FICHERO para almacenarlo con JsonWriterFactory
        JsonWriterFactory jsonFactory = Json.createWriterFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));
        
        try {
            JsonWriter jsonW = jsonFactory.createWriter(new FileOutputStream("./datos/ windows.json"));
            jsonW.writeArray(arrayJ); // ESCRIBE objeto JSON con jsonWriter creado con factory
            jsonW.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppDhcpXMLtoJSON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
