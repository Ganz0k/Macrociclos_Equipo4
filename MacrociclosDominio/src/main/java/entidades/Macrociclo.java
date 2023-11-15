/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.Rama;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class Macrociclo {
    
    private ObjectId id;
    private ObjectId entrenador;
    private String status;
    private String deporte;
    private Rama rama;
    private String jefeRama;
    private String entrenadorAuxiliar;
    private String metodologo;
    private Date fechaInicio;
    private Date fechaFin;
    private int semanasGeneral;
    private int semanasEspecial;
    private int semanasCompetitivo;
    private List<MedioFisico> mediosFisicos;
    private List<Mesociclo> mesociclos;

    public Macrociclo() {
        
    }

    public Macrociclo(ObjectId id, ObjectId entrenador, String status, String deporte, Rama rama, String jefeRama, String entrenadorAuxiliar, String metodologo, Date fechaInicio, Date fechaFin, int semanasGeneral, int semanasEspecial, int semanasCompetitivo, List<MedioFisico> mediosFisicos, List<Mesociclo> mesociclos) {
        this.id = id;
        this.entrenador = entrenador;
        this.status = status;
        this.deporte = deporte;
        this.rama = rama;
        this.jefeRama = jefeRama;
        this.entrenadorAuxiliar = entrenadorAuxiliar;
        this.metodologo = metodologo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.semanasGeneral = semanasGeneral;
        this.semanasEspecial = semanasEspecial;
        this.semanasCompetitivo = semanasCompetitivo;
        this.mediosFisicos = mediosFisicos;
        this.mesociclos = mesociclos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(ObjectId entrenador) {
        this.entrenador = entrenador;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public Rama getRama() {
        return rama;
    }

    public void setRama(Rama rama) {
        this.rama = rama;
    }

    public String getJefeRama() {
        return jefeRama;
    }

    public void setJefeRama(String jefeRama) {
        this.jefeRama = jefeRama;
    }

    public String getEntrenadorAuxiliar() {
        return entrenadorAuxiliar;
    }

    public void setEntrenadorAuxiliar(String entrenadorAuxiliar) {
        this.entrenadorAuxiliar = entrenadorAuxiliar;
    }

    public String getMetodologo() {
        return metodologo;
    }

    public void setMetodologo(String metodologo) {
        this.metodologo = metodologo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getSemanasGeneral() {
        return semanasGeneral;
    }

    public void setSemanasGeneral(int semanasGeneral) {
        this.semanasGeneral = semanasGeneral;
    }

    public int getSemanasEspecial() {
        return semanasEspecial;
    }

    public void setSemanasEspecial(int semanasEspecial) {
        this.semanasEspecial = semanasEspecial;
    }

    public int getSemanasCompetitivo() {
        return semanasCompetitivo;
    }

    public void setSemanasCompetitivo(int semanasCompetitivo) {
        this.semanasCompetitivo = semanasCompetitivo;
    }

    public List<MedioFisico> getMediosFisicos() {
        return mediosFisicos;
    }

    public void setMediosFisicos(List<MedioFisico> mediosFisicos) {
        this.mediosFisicos = mediosFisicos;
    }

    public List<Mesociclo> getMesociclos() {
        return mesociclos;
    }

    public void setMesociclos(List<Mesociclo> mesociclos) {
        this.mesociclos = mesociclos;
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
        final Macrociclo other = (Macrociclo) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Macrociclo{" + "id=" + id + ", entrenador=" + entrenador + ", deporte=" + deporte + ", rama=" + rama + ", jefeRama=" + jefeRama + ", entrenadorAuxiliar=" + entrenadorAuxiliar + ", metodologo=" + metodologo + ", fechaInicio=" + fechaInicio + ", fechafin=" + fechaFin + ", semanasGeneral=" + semanasGeneral + ", semanasEspecial=" + semanasEspecial + ", semanasCompetitivo=" + semanasCompetitivo + ", mediosFisicos=" + mediosFisicos + ", mesociclos=" + mesociclos + '}';
    }
}
