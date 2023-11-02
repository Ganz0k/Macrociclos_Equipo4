/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import java.util.List;

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

    public boolean guardarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) throws PersistenciaException {
        if (idMacrociclo == null || idMesociclo == null || volumenesMediosFisicos == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }
        
        volumenesMediosFisicos.forEach(vME -> {
            if (vME.getId() == null || vME.getMedioFisico() == null) {
                throw new NegocioException("Ninguno de los campos puede ser nulo");
            }

            if (vME.getPorcentaje() < 0 || vME.getVolumen() < 0) {
                throw new NegocioException("Solo se aceptan decimales positivos");
            }
        });

        return fachadaDatos.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, volumenesMediosFisicos);
    }
}
