/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.dam.mavenjson;
import java.io.StringWriter;
import java.util.Collections;
import javax.json.Json;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

public class MavenJson {

    public static void main(String[] args) {
        StringWriter sw = new StringWriter();

        JsonGeneratorFactory jsonGeneratorFactory = 
            Json.createGeneratorFactory(Collections.singletonMap(
                JsonGenerator.PRETTY_PRINTING, true));
        JsonGenerator generator = jsonGeneratorFactory.createGenerator(sw);

        generator.writeStartObject()
            .write("title","JSON-Processing With Java EE")
            .writeStartArray("chapters")
              .write("Introduction")
              .write("1. JSON and Java")
              .write("2. JSON-Processing API features")
              .write("3. The Java EE JSON Object model")
              .write("4. The Java EE JSON Streaming model")
              .write("Conclusion")
            .writeEnd()
            .write("released",JsonValue.TRUE)
            .write("length",90)
            .writeStartObject("sourceCode")
              .write("repositoryName", "JSON-Processing-with-Java-EE")
              .write("url","github.com/readlearncode")
            .writeEnd()
            .writeStartArray("complementaryCourse")
              .writeStartObject()
                .write("title", "RESTful Service with JAX-RS 2.0")
                .write("length", 120)
              .writeEnd()
              .writeStartObject()
                .write("title", "Java Enterprise Edition Introduction")
                .write("length", 130)
              .writeEnd()
            .writeEnd()
            .write("notes", JsonValue.NULL)
          .writeEnd();        

        generator.close();
        
        // Mostrar el objeto StringWriter
        System.out.println(sw.toString());        
    }
    
}
