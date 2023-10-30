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
    private String deporte;
    private Rama rama;
    private String jefeRama;
    private ObjectId entrenadorAuxiliar;
    private ObjectId metodologo;
    private Date fechaInicio;
    private Date fechafin;
    private int semanasGeneral;
    private int semanasEspecial;
    private int semanasPrecompetitivo;
    private int semanasCompetitivo;
    private List<MedioFisico> mediosFisicos;
    private List<Mesociclo> mesociclos;

    public Macrociclo(ObjectId id, ObjectId entrenador, String deporte, Rama rama, String jefeRama, ObjectId entrenadorAuxiliar, ObjectId metodologo, Date fechaInicio, Date fechafin, int semanasGeneral, int semanasEspecial, int semanasPrecompetitivo, int semanasCompetitivo, List<MedioFisico> mediosFisicos, List<Mesociclo> mesociclos) {
        this.id = id;
        this.entrenador = entrenador;
        this.deporte = deporte;
        this.rama = rama;
        this.jefeRama = jefeRama;
        this.entrenadorAuxiliar = entrenadorAuxiliar;
        this.metodologo = metodologo;
        this.fechaInicio = fechaInicio;
        this.fechafin = fechafin;
        this.semanasGeneral = semanasGeneral;
        this.semanasEspecial = semanasEspecial;
        this.semanasPrecompetitivo = semanasPrecompetitivo;
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

    public ObjectId getEntrenadorAuxiliar() {
        return entrenadorAuxiliar;
    }

    public void setEntrenadorAuxiliar(ObjectId entrenadorAuxiliar) {
        this.entrenadorAuxiliar = entrenadorAuxiliar;
    }

    public ObjectId getMetodologo() {
        return metodologo;
    }

    public void setMetodologo(ObjectId metodologo) {
        this.metodologo = metodologo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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

    public int getSemanasPrecompetitivo() {
        return semanasPrecompetitivo;
    }

    public void setSemanasPrecompetitivo(int semanasPrecompetitivo) {
        this.semanasPrecompetitivo = semanasPrecompetitivo;
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
        return "Macrociclo{" + "id=" + id + ", entrenador=" + entrenador + ", deporte=" + deporte + ", rama=" + rama + ", jefeRama=" + jefeRama + ", entrenadorAuxiliar=" + entrenadorAuxiliar + ", metodologo=" + metodologo + ", fechaInicio=" + fechaInicio + ", fechafin=" + fechafin + ", semanasGeneral=" + semanasGeneral + ", semanasEspecial=" + semanasEspecial + ", semanasPrecompetitivo=" + semanasPrecompetitivo + ", semanasCompetitivo=" + semanasCompetitivo + ", mediosFisicos=" + mediosFisicos + ", mesociclos=" + mesociclos + '}';
    }
}
