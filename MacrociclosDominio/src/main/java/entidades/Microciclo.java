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
    private String acento;
    private List<VolumenMedioFisico> volumenesMediosFisicos;
    private boolean competenciaPreparativa;
    private boolean testFisico;
    
    public Microciclo() {
        
    }
    
    public Microciclo(ObjectId id, Date inicio, Date fin, String acento, List<VolumenMedioFisico> volumenesMediosFisicos, boolean competenciaPreparativa, boolean testFisico) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.acento = acento;
        this.volumenesMediosFisicos = volumenesMediosFisicos;
        this.competenciaPreparativa = competenciaPreparativa;
        this.testFisico = testFisico;
    }

    public Microciclo(Date inicio, Date fin, String acento, List<VolumenMedioFisico> volumenesMediosFisicos, boolean competenciaPreparativa, boolean testFisico) {
        this.inicio = inicio;
        this.fin = fin;
        this.acento = acento;
        this.volumenesMediosFisicos = volumenesMediosFisicos;
        this.competenciaPreparativa = competenciaPreparativa;
        this.testFisico = testFisico;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getAcento() {
        return acento;
    }

    public void setAcento(String acento) {
        this.acento = acento;
    }

    public List<VolumenMedioFisico> getVolumenesMediosFisicos() {
        return volumenesMediosFisicos;
    }

    public void setVolumenesMediosFisicos(List<VolumenMedioFisico> volumenesMediosFisicos) {
        this.volumenesMediosFisicos = volumenesMediosFisicos;
    }

    public boolean isCompetenciaPreparativa() {
        return competenciaPreparativa;
    }

    public void setCompetenciaPreparativa(boolean competenciaPreparativa) {
        this.competenciaPreparativa = competenciaPreparativa;
    }

    public boolean isTestFisico() {
        return testFisico;
    }

    public void setTestFisico(boolean testFisico) {
        this.testFisico = testFisico;
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
