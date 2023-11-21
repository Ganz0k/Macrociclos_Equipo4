/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.MedioFisico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachada.FachadaDatos;
import interfaces.IDatos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class MedioFisicoController {
    
    private final IDatos fachadaDatos;
    
    public MedioFisicoController() {
        this.fachadaDatos = new FachadaDatos();
    }
    
    public boolean guardarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) throws PersistenciaException {
        if (idMacrociclo == null || mediosFisicos == null) {
            throw new NegocioException("No se aceptan nulos");
        }
        
        if (mediosFisicos.isEmpty()) {
            throw new NegocioException("Debe de haber por lo menos 1 medio físico");
        }
        
        return this.fachadaDatos.guardarMediosFisicos(idMacrociclo, mediosFisicos);
    }
}
