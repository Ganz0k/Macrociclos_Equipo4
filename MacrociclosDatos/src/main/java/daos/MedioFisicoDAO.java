/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.MedioFisico;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author Yorsh
 */
public class MedioFisicoDAO {
    
    private final MongoDatabase baseDatos;
    
    public MedioFisicoDAO() {
        this.baseDatos = ConexionBD.crearConexion();
    }
    
    private MongoCollection<MedioFisico> getColeccion() {
        return this.baseDatos.getCollection("mediofisico", MedioFisico.class);
    }
    
     public boolean guardarMacrociclo(MedioFisico medioFisico) {
        try {
            if (medioFisico == null) {
                return false;
            }
            
            MongoCollection<MedioFisico> coleccion = this.getColeccion();
            coleccion.insertOne(medioFisico);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
     
     public MedioFisico obtenerMacrociclo(ObjectId id) {
        try {
            MongoCollection<MedioFisico> coleccion = this.getColeccion();
            
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
}
