/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eetxa
 */
@XmlRootElement(name="extras")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extras implements Serializable {
    @XmlElement(name="dvd")
    boolean dvd;
    @XmlElement(name ="lector_tarjetas")           
    boolean lector_tarjetas;
    @XmlElement(name = "video")
    String video;

    public Extras() {
    }

    public Extras(boolean dvd, boolean lector_tarjetas, String video) {
        this.dvd = dvd;
        this.lector_tarjetas = lector_tarjetas;
        this.video = video;
    }

    public boolean isDvd() {
        return dvd;
    }

    public void setDvd(boolean dvd) {
        this.dvd = dvd;
    }

    public boolean isLector_tarjetas() {
        return lector_tarjetas;
    }

    public void setLector_tarjetas(boolean lector_tarjetas) {
        this.lector_tarjetas = lector_tarjetas;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Extras{" + "dvd=" + dvd + ", lector_tarjetas=" + lector_tarjetas + ", video=" + video + '}';
    }
    
}
