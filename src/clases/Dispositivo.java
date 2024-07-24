/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author eetxa
 */
@XmlRootElement(name="dispositivo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"codigo","marca","sisope","usuarios","extras","ramgb","hdgb"})
public class Dispositivo implements Serializable {
    @XmlAttribute(name ="codigo")
    String codigo;
    @XmlElement(name = "marca")
    String marca;
    @XmlElement(name ="sisope")
    String sisope;
    
    @XmlElementWrapper(name="usuarios")
    @XmlElement(name ="usuario")
    ArrayList<String> usuarios;
    @XmlElement(name = "extras")
    Extras extras;
    @XmlElement(name = "ramgb")
    int ramgb;
    @XmlElement(name = "hdgb")
    int hdgb;

    public Dispositivo() {
    }

    public Dispositivo(String codigo, String marca, String sisope, ArrayList<String> usuarios, Extras extras, int ramgb, int hdgb) {
        this.codigo = codigo;
        this.marca = marca;
        this.sisope = sisope;
        this.usuarios = usuarios;
        this.extras = extras;
        this.ramgb = ramgb;
        this.hdgb = hdgb;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSisope() {
        return sisope;
    }

    public void setSisope(String sisope) {
        this.sisope = sisope;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public Extras getExtras() {
        return extras;
    }

    public void setExtras(Extras extras) {
        this.extras = extras;
    }

    public int getRamgb() {
        return ramgb;
    }

    public void setRamgb(int ramgb) {
        this.ramgb = ramgb;
    }

    public int getHdgb() {
        return hdgb;
    }

    public void setHdgb(int hdgb) {
        this.hdgb = hdgb;
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "codigo=" + codigo + ", marca=" + marca + ", sisope=" + sisope + ", usuarios=" + usuarios + ", extras=" + extras + ", rambg=" + ramgb + ", hdgb=" + hdgb + '}';
    }
    
    
    
    
}
