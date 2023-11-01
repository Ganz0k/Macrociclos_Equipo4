/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import controles.MicrocicloController;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import interfaces.INegocio;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class FachadaNegocio implements INegocio {

    private final MicrocicloController microcicloController;
    
    public FachadaNegocio() {
        this.microcicloController = new MicrocicloController();
    }
    
    @Override
    public boolean guardarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
        return this.microcicloController.guardarMicrociclo(idMacrociclo, idMesociclo, microciclos);
    }
    
}
