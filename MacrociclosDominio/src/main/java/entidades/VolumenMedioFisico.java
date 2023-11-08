/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class VolumenMedioFisico {

    private ObjectId id;
    private ObjectId medioFisico;
    private float volumen;
    private float porcentaje;
    
    public VolumenMedioFisico() {
        
    }
    
    public VolumenMedioFisico(ObjectId medioFisico) {
        this.medioFisico = medioFisico;
    }

    public VolumenMedioFisico(ObjectId id, ObjectId medioFisico, float volumen, float porcentaje) {
        this.id = id;
        this.medioFisico = medioFisico;
        this.volumen = volumen;
        this.porcentaje = porcentaje;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getMedioFisico() {
        return medioFisico;
    }

    public void setMedioFisico(ObjectId medioFisico) {
        this.medioFisico = medioFisico;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VolumenMedioFisico other = (VolumenMedioFisico) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "VolumenMedioFisico{" + "id=" + id + ", medioFisico=" + medioFisico + ", volumen=" + volumen + ", porcentaje=" + porcentaje + '}';
    }
}
