/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import enumeradores.Etapa;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class MedioFisico {
    
    private ObjectId id;
    private String nombre;
    private Etapa etapa;
    private int minimo;
    private int maximo;
    private int promedio;
    private int vecesPorSemana;
    private int volumen;

    public MedioFisico(ObjectId id, String nombre, Etapa etapa, int minimo, int maximo, int promedio, int vecesPorSemana, int volumen) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.vecesPorSemana = vecesPorSemana;
        this.volumen = volumen;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public int getVecesPorSemana() {
        return vecesPorSemana;
    }

    public void setVecesPorSemana(int vecesPorSemana) {
        this.vecesPorSemana = vecesPorSemana;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final MedioFisico other = (MedioFisico) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "MedioFisico{" + "id=" + id + ", nombre=" + nombre + ", etapa=" + etapa + ", minimo=" + minimo + ", maximo=" + maximo + ", promedio=" + promedio + ", vecesPorSemana=" + vecesPorSemana + ", volumen=" + volumen + '}';
    }
}
