/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teststuff;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ConexionBD;
import entidades.Macrociclo;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class MacrocicloDAOTest {
    
    
    private final MongoDatabase baseDatos;
    
    public MacrocicloDAOTest() {
        this.baseDatos = ConexionBD.crearConexion();
    }
    
    private MongoCollection<Macrociclo> getColeccion() {
        return this.baseDatos.getCollection("macrociclos", Macrociclo.class);
    }
    
    public Macrociclo obtenerMacrociclo(ObjectId id) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            
            return coleccion.find(Filters.eq("_id", id)).first();
        } catch (Exception e) {
            System.err.println(e.getMessage() + "\n" + e.getCause());
            return null;
        }
    }
}
