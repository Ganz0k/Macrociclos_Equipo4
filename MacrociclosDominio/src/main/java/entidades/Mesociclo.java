/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.Etapa;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class Mesociclo {

    private ObjectId id;
    private int numero;
    private Etapa etapa;
    private List<VolumenMedioFisico> distribucionVolumen;
    private List<Microciclo> microciclos;

    /**
     * Constructor que inicializa todos los atributos del mesosciclo
     *
     * @param id id del mesociclo
     * @param numero número de mesociclo que este es
     * @param etapa etapa a la que pertenece este mesociclo
     * @param distribucionVolumen lista de distribuciones de volumen de cada
     * medio físico a trabajar en este mesociclo
     * @param microciclos lista de microciclos que comprenden este mesociclo
     */
    public Mesociclo(ObjectId id, int numero, Etapa etapa, List<VolumenMedioFisico> distribucionVolumen, List<Microciclo> microciclos) {
        this.id = id;
        this.numero = numero;
        this.etapa = etapa;
        this.distribucionVolumen = distribucionVolumen;
        this.microciclos = microciclos;
    }

    /**
     * Regresa el id del mesociclo
     *
     * @return id del mesociclo
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un nuevo id al mesociclo
     *
     * @param id id a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el número de mesociclo que este es
     *
     * @return número de mesociclo que este es
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Le asigna un nuevo número al mesociclo
     *
     * @param numero número a asignar al mesociclo
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Regresa la etapa a la que pertenece este mesociclo
     *
     * @return etapa a la que pertenece este mesociclo
     */
    public Etapa getEtapa() {
        return etapa;
    }

    /**
     * Le asigna una nueva etapa al mesociclo
     *
     * @param etapa etapa a asignar
     */
    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    /**
     * Regresa la lista de distibuciones de volúmenes de medios físicos de este
     * mesociclo
     *
     * @return lista de distribuciones de volúmenes de medios físicos de este
     * mesociclo
     */
    public List<VolumenMedioFisico> getDistribucionVolumen() {
        return distribucionVolumen;
    }

    /**
     * Le asigna una nueva lista de distribuciones de volúmenes de medios
     * físicos al mesociclo
     *
     * @param distribucionVolumen lista de distribuciones de volúmenes de medios
     * físicos a asignar
     */
    public void setDistribucionVolumen(List<VolumenMedioFisico> distribucionVolumen) {
        this.distribucionVolumen = distribucionVolumen;
    }

    /**
     * Regresa la lista de microciclos de este mesociclo
     *
     * @return lista de microciclos de este mescociclo
     */
    public List<Microciclo> getMicrociclos() {
        return microciclos;
    }

    /**
     * Le asigna una nueva lista de microciclos al mesociclo
     *
     * @param microciclos lista de microciclos a asignar
     */
    public void setMicrociclos(List<Microciclo> microciclos) {
        this.microciclos = microciclos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Mesociclo other = (Mesociclo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Mesociclo{" + "id=" + id + ", numero=" + numero + ", etapa=" + etapa + ", distribucionVolumen=" + distribucionVolumen + ", microciclos=" + microciclos + '}';
    }
}
