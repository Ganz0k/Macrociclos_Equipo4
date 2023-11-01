/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Microciclo;
import org.bson.types.ObjectId;

public class MicrocicloDAO {
    
    private final MongoDatabase baseDatos;
    
    public MicrocicloDAO() {
        this.baseDatos = ConexionBD.crearConexion();
    }
    
    private MongoCollection<Microciclo> getColeccion() {
        return this.baseDatos.getCollection("microciclos", Microciclo.class);
    }
    
    public boolean guardarMicrociclo(Microciclo microciclo) {
        try {
            MongoCollection<Microciclo> coleccion = this.getColeccion();
            coleccion.insertOne(microciclo);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            return false;
        }
    }
    
    public Microciclo buscarMicrocicloPorId(ObjectId id) {
        MongoCollection<Microciclo> coleccion = this.getColeccion();
        return coleccion.find(Filters.eq("_id", id)).first();
    }
    
    public boolean eliminarMicrociclo(ObjectId id) {
        try {
            MongoCollection<Microciclo> coleccion = this.getColeccion();
            coleccion.deleteOne(Filters.eq("_id", id));
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            return false;
        }
    }
}
