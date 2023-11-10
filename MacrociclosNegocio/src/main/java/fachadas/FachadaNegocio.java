/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachadas;

import controles.DistribucionVolumenMedioFisicoController;
import controles.MacrocicloController;
import controles.MicrocicloController;
import entidades.Macrociclo;
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
    private final MacrocicloController macrocicloController;
    
    public FachadaNegocio() {
        this.microcicloController = new MicrocicloController();
        this.distribucionVolumenMedioFisicoController = new DistribucionVolumenMedioFisicoController();
        this.macrocicloController = new MacrocicloController();
    }
    
    @Override
    public boolean guardarVolumenMedioFisicoEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws PersistenciaException, NegocioException {
        return this.distribucionVolumenMedioFisicoController.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, volumenMedioFisico);
    }

    @Override
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
        return this.microcicloController.guardarMicrociclo(idMacrociclo, idMesociclo, microciclos);
    }

    @Override
    public boolean eliminarDistribuciones(ObjectId idMacrociclo) throws NegocioException, PersistenciaException {
        return this.distribucionVolumenMedioFisicoController.eliminarDistribuciones(idMacrociclo);
    }

    @Override
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) throws NegocioException, PersistenciaException {
        return this.microcicloController.eliminarMicrociclos(idMacrociclo);
    }

    @Override
    public boolean guardarMacrociclo(Macrociclo macrociclo) throws NegocioException, PersistenciaException {
        return this.macrocicloController.guardarMacrociclo(macrociclo);
    }

    @Override
    public Macrociclo obtenerMacrociclo(ObjectId idMacrociclo) throws NegocioException, PersistenciaException {
        return this.macrocicloController.obtenerMacrociclo(idMacrociclo);
    }
}
