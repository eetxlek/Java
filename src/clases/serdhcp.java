/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eetxa
 */
@XmlRootElement(name = "serdhcp")
@XmlAccessorType(XmlAccessType.FIELD)
public class serdhcp implements Serializable {

    @XmlElement(name = "dispositivo")
    ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    public serdhcp() {
    }

    public ArrayList<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public void add(Dispositivo d) {
        this.dispositivos.add(d);
    }

    @Override
    public String toString() {
        return "serdhcp{" + "dispositivos=" + dispositivos + '}';
    }
    
}
