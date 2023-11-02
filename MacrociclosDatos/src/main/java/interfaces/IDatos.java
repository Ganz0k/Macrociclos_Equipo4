/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

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
    
    public boolean guardarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) throws PersistenciaException;
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos);
}
