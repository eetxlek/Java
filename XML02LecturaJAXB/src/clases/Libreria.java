
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="libreria")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"nombre","libros"})
public class Libreria implements Serializable {
    @XmlElement(name="nombre")
    private String nombre;

    @XmlElementWrapper(name="libros")
    @XmlElement(name="libro")
    private ArrayList<Libro> libros = new ArrayList<>();

    // **********************************
    // Constructor
    public Libreria() {
    }

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    
    // getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Libro> getLibros() {
        return libros;
    }
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public void add(Libro libro) {
        this.libros.add(libro);
    }

    @Override
    public String toString() {
        return "Libreria{" + "nombre=" + nombre + ", libros=" + libros + '}';
    }
    
}