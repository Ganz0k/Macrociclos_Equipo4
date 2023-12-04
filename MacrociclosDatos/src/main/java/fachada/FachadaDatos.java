/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import daos.MacrocicloDAO;
import daos.MedioFisicoDAO;
import daos.MicrocicloDAO;
import daos.VolumenMedioFisicoDAO;
import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import excepciones.PersistenciaException;
import interfaces.IDatos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class FachadaDatos implements IDatos {
    
    private final MicrocicloDAO microcicloDAO;
    private final VolumenMedioFisicoDAO volumenMedioFisicoDAO;
    private final MacrocicloDAO macrocicloDAO;
    private final MedioFisicoDAO medioFisicoDAO;
    
    public FachadaDatos() {
        this.microcicloDAO = new MicrocicloDAO();
        this.volumenMedioFisicoDAO = new VolumenMedioFisicoDAO();
        this.macrocicloDAO = new MacrocicloDAO();
        this.medioFisicoDAO = new MedioFisicoDAO();
    }

    @Override
    public boolean actualizarVolumenMedioFisicoEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws PersistenciaException {
        return this.volumenMedioFisicoDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, volumenMedioFisico);
    }

    @Override
    public boolean actualizarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) throws PersistenciaException {
        return this.microcicloDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos);
    }

    @Override
    public boolean eliminarDistribucionesVolumenes(ObjectId idMacrociclo) throws PersistenciaException {
        return this.volumenMedioFisicoDAO.eliminarDistribucionesVolumenes(idMacrociclo);
    }

    @Override
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) throws PersistenciaException {
        return this.microcicloDAO.eliminarMicrociclos(idMacrociclo);
    }

    @Override
    public boolean guardarMacrociclo(Macrociclo macrociclo) throws PersistenciaException {
        return this.macrocicloDAO.guardarMacrociclo(macrociclo);
    }

    @Override
    public Macrociclo obtenerMacrociclo(ObjectId idMacrociclo) throws PersistenciaException {
        return this.macrocicloDAO.obtenerMacrociclo(idMacrociclo);
    }

    @Override
    public boolean actualizarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) throws PersistenciaException {
        return this.medioFisicoDAO.actualizarMediosFisicos(idMacrociclo, mediosFisicos);
    }

    @Override
    public boolean actualizarMacrociclo(Macrociclo macrociclo) throws PersistenciaException {
        return this.macrocicloDAO.actualizarMacrociclo(macrociclo);
    }

    @Override
    public boolean actualizarStatus(ObjectId idMacrociclo, String nuevoEstado) throws PersistenciaException {
        return this.macrocicloDAO.actualizarStatus(idMacrociclo, nuevoEstado);
    }

    @Override
    public List<Macrociclo> obtenerMacrociclosNoAprobados() throws PersistenciaException {
        return this.macrocicloDAO.obtenerMacrociclosNoAprobados();
    }
}
