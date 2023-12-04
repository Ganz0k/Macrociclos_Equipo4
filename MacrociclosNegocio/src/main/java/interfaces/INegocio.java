/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public interface INegocio {
    
    public boolean actualizarVolumenMedioFisicoEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws NegocioException, PersistenciaException;
    
    public boolean actualizarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) throws NegocioException, PersistenciaException;
    
    public boolean eliminarDistribuciones(ObjectId idMacrociclo) throws NegocioException, PersistenciaException;
    
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) throws NegocioException, PersistenciaException;
    
    public boolean guardarMacrociclo(Macrociclo macrociclo) throws NegocioException, PersistenciaException;
    
    public Macrociclo obtenerMacrociclo(ObjectId idMacrociclo) throws NegocioException, PersistenciaException;
    
    public boolean actualizarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) throws NegocioException, PersistenciaException;

    public boolean actualizarMacrociclo(Macrociclo macrociclo) throws NegocioException, PersistenciaException;
    
    public boolean validarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) throws NegocioException;
    
    public boolean validarVolumenMedioFisico(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws NegocioException;

    public boolean validarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) throws NegocioException;

    public List<Macrociclo> obtenerMacrociclosNoAprobados() throws NegocioException;
}
