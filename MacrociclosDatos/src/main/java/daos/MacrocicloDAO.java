/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Macrociclo;
import excepciones.PersistenciaException;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class MacrocicloDAO {
    
    private final MongoDatabase baseDatos;
    
    public MacrocicloDAO() {
        this.baseDatos = ConexionBD.crearConexion();
    }
    
    private MongoCollection<Macrociclo> getColeccion() {
        return this.baseDatos.getCollection("macrociclos", Macrociclo.class);
    }
    
    public boolean guardarMacrociclo(Macrociclo macrociclo) {
        try {
            if (macrociclo == null) {
                return false;
            }
            
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            coleccion.insertOne(macrociclo);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
    
    public Macrociclo obtenerMacrociclo(ObjectId id) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
}
