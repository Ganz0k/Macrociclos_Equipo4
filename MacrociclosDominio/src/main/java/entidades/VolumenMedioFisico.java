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
    private int porcentaje;
    
    public VolumenMedioFisico() {
        
    }

    /**
     * Constructor que inicializa todos los atributos del volumen
     *
     * @param id id del volumen del medio físico
     * @param medioFisico id del medio físico al que pertenece este volumen de
     * medio físico
     * @param volumen el total del volumen que será trabajado en un mesociclo de
     * este medio físico
     * @param porcentaje porcentaje de volumen que será trabajado el medio
     * físico en el mesociclo
     */
    public VolumenMedioFisico(ObjectId id, ObjectId medioFisico, float volumen, int porcentaje) {
        this.id = id;
        this.medioFisico = medioFisico;
        this.volumen = volumen;
        this.porcentaje = porcentaje;
    }

    /**
     * Regresa el id del volumen de medio físico
     *
     * @return id del volumen de medio físico
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un nuevo id al volumen de medio físico
     *
     * @param id id a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el id del medio físico
     *
     * @return id del medio físico
     */
    public ObjectId getMedioFisico() {
        return medioFisico;
    }

    /**
     * Le asigna un nuevo id de medio físico al volumen de medio físico
     *
     * @param medioFisico id de medio físico a asignar
     */
    public void setMedioFisico(ObjectId medioFisico) {
        this.medioFisico = medioFisico;
    }

    /**
     * Regresa el total de volumen que será trabajado en un mesociclo de este
     * medio físico
     *
     * @return
     */
    public float getVolumen() {
        return volumen;
    }

    /**
     * Le asigna un nuevo volumen a ser trabajado
     *
     * @param volumen volumen a asignar
     */
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    /**
     * Regresa el porcentaje de volumen que será trabajado el medio físico en un
     * mesociclo
     *
     * @return
     */
    public int getPorcentaje() {
        return porcentaje;
    }

    /**
     * Le asigna un nuevo porcentaje de volumen que será trabajado el medio
     * físico en un mesociclo
     *
     * @param porcentaje porcentaje a asignar
     */
    public void setPorcentaje(int porcentaje) {
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
