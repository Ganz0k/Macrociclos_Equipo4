/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import org.bson.types.ObjectId;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachada.FachadaDatos;
import interfaces.IDatos;

/**
 *
 * @author luisg
 */
public class DistribucionVolumenMedioFisicoController {
    
    private final IDatos fachadaDatos;

    public DistribucionVolumenMedioFisicoController() {
        fachadaDatos = new FachadaDatos();
    }

    public boolean actualizarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws PersistenciaException {
        if (idMacrociclo == null || idMesociclo == null || volumenMedioFisico == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }
        
        if (volumenMedioFisico.getId() == null || volumenMedioFisico.getMedioFisico() == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }

        if (volumenMedioFisico.getPorcentaje() < 0 || volumenMedioFisico.getVolumen() < 0) {
            throw new NegocioException("Solo se aceptan decimales positivos");
        }

        return fachadaDatos.actualizarVolumenMedioFisicoEnMesociclo(idMacrociclo, idMesociclo, volumenMedioFisico);
    }
    
    public boolean eliminarDistribuciones(ObjectId idMacrociclo) throws PersistenciaException {
        if (idMacrociclo == null) {
            throw new NegocioException("El id no puede ser null");
        }
        
        return fachadaDatos.eliminarDistribucionesVolumenes(idMacrociclo);
    }
    
    public boolean validarVolumenMedioFisico(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) {
        if (idMacrociclo == null || idMesociclo == null || volumenMedioFisico == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }
        
        if (volumenMedioFisico.getId() == null || volumenMedioFisico.getMedioFisico() == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }

        if (volumenMedioFisico.getPorcentaje() < 0 || volumenMedioFisico.getVolumen() < 0) {
            throw new NegocioException("Solo se aceptan decimales positivos");
        }
        
        return true;
    }
}
