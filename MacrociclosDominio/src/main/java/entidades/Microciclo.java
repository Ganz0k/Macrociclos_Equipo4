/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class Microciclo {

    private ObjectId id;
    private Date inicio;
    private Date fin;
    private int acento;
    private List<VolumenMedioFisico> volumenesMediosFisicos;
    private boolean competenciaPreparativa;
    
    public Microciclo() {
        
    }

    /**
     * Constructor que inicializa todos los atributos del microciclo
     *
     * @param id id del microciclo
     * @param inicio fecha de inicio del microciclo
     * @param fin fecha de fin del microciclo
     * @param acento acento que representa el trabajo que se realizará en el
     * microciclo
     * @param volumenesMediosFisicos volúmenes de medios físicos que se
     * trabajarán en el microciclo
     * @param competenciaPreparativa representa si durante este microciclo habrá
     * una competencia preparativa
     */
    public Microciclo(ObjectId id, Date inicio, Date fin, int acento, List<VolumenMedioFisico> volumenesMediosFisicos, boolean competenciaPreparativa) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.acento = acento;
        this.volumenesMediosFisicos = volumenesMediosFisicos;
        this.competenciaPreparativa = competenciaPreparativa;
    }

    public Microciclo(Date inicio, Date fin, int acento, List<VolumenMedioFisico> volumenesMediosFisicos, boolean competenciaPreparativa) {
        this.inicio = inicio;
        this.fin = fin;
        this.acento = acento;
        this.volumenesMediosFisicos = volumenesMediosFisicos;
        this.competenciaPreparativa = competenciaPreparativa;
    }

    /**
     * Regresa el id del microciclo
     *
     * @return id del microciclo
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Le asigna un nuevo id al microciclo
     *
     * @param id id a asignar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa la fecha de inicio del microciclo
     *
     * @return fecha de inicio del microciclo
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * Le asigna una nueva fecha de inicio al microciclo
     *
     * @param inicio fecha de inicio a asignar
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * Regresa la fecha de fin del microciclo
     *
     * @return fecha de fin del microciclo
     */
    public Date getFin() {
        return fin;
    }

    /**
     * Le asigna una nueva fecha de fin al microciclo
     *
     * @param fin fecha de fin a asignar
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    /**
     * Regresa el acento que este microciclo representa
     *
     * @return acento que este microciclo representa
     */
    public int getAcento() {
        return acento;
    }

    /**
     * Le asigna un nuevo acento al microciclo
     *
     * @param acento acento a asignar al microciclo
     */
    public void setAcento(int acento) {
        this.acento = acento;
    }

    /**
     * Regresa la lista de medios físicos que se trabajarán en el microciclo
     *
     * @return lista de medios físicos que se trabajarán en el microciclo
     */
    public List<VolumenMedioFisico> getVolumenesMediosFisicos() {
        return volumenesMediosFisicos;
    }

    /**
     * Le asigna una nueva lista de volúmenes de medios físicos que se
     * trabajarán en el microciclo
     *
     * @param volumenesMediosFisicos lista de volúmenes de medios físicos a
     * asignar
     */
    public void setVolumenesMediosFisicos(List<VolumenMedioFisico> volumenesMediosFisicos) {
        this.volumenesMediosFisicos = volumenesMediosFisicos;
    }

    /**
     * Regresa si este microciclo representa una competencia preparativa o nos
     *
     * @return true o false
     */
    public boolean isCompetenciaPreparativa() {
        return competenciaPreparativa;
    }

    /**
     * Le asigna un nuevo valor a la variable de competenciaPreparativa
     *
     * @param competenciaPreparativa nuevo valor a asignarle a la variable
     * competenciaPreparativa
     */
    public void setCompetenciaPreparativa(boolean competenciaPreparativa) {
        this.competenciaPreparativa = competenciaPreparativa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Microciclo other = (Microciclo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Microciclo{" + "id=" + id + ", inicio=" + inicio + ", fin=" + fin + ", acento=" + acento + ", mediosFisicos=" + volumenesMediosFisicos + ", competenciaPreparativa=" + competenciaPreparativa + '}';
    }
}
