/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import controles.DistribucionVolumenMedioFisicoController;
import controles.MicrocicloController;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.INegocio;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class FachadaNegocio implements INegocio {

    private final MicrocicloController microcicloController;
    private final DistribucionVolumenMedioFisicoController distribucionVolumenMedioFisicoController;
    
    public FachadaNegocio() {
        this.microcicloController = new MicrocicloController();
        this.distribucionVolumenMedioFisicoController = new DistribucionVolumenMedioFisicoController();
    }
    
    @Override
    public boolean guardarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) throws PersistenciaException, NegocioException {
        return this.distribucionVolumenMedioFisicoController.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, volumenesMediosFisicos);
    }

    @Override
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
        return this.microcicloController.guardarMicrociclo(idMacrociclo, idMesociclo, microciclos);
    }
    
}
