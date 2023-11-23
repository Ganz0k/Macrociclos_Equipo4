/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import excepciones.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public interface IDatos {
    
    public boolean actualizarVolumenMedioFisicoEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) throws PersistenciaException;
    
    public boolean actualizarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) throws PersistenciaException;
    
    public boolean eliminarDistribucionesVolumenes(ObjectId idMacrociclo) throws PersistenciaException;
    
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) throws PersistenciaException;
    
    public boolean guardarMacrociclo(Macrociclo macrociclo) throws PersistenciaException;
    
    public Macrociclo obtenerMacrociclo(ObjectId idMacrociclo) throws PersistenciaException;
    
    public boolean actualizarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) throws PersistenciaException;

    public boolean actualizarMacrociclo(Macrociclo macrociclo) throws PersistenciaException;
}
