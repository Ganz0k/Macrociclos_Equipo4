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
import entidades.Mesociclo;
import entidades.Microciclo;
import java.util.List;
import org.bson.types.ObjectId;

public class MicrocicloDAO {
    
    private final MongoDatabase baseDatos;
    
    public MicrocicloDAO() {
        this.baseDatos = ConexionBD.crearConexion();
    }
    
    private MongoCollection<Macrociclo> getColeccion() {
        return this.baseDatos.getCollection("macrociclos", Macrociclo.class);
    }
    
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();
            
            if (macrociclo != null) {
                List<Mesociclo> mesociclos = macrociclo.getMesociclos();
                
                for (int i = 0; i < mesociclos.size(); i++) {
                    if (mesociclos.get(i).getId().equals(idMesociclo)) {
                        mesociclos.get(i).setMicrociclos(microciclos);
                        macrociclo.setMesociclos(mesociclos);
                        break;
                    }
                }
                
                coleccion.findOneAndReplace(Filters.eq("_id", idMacrociclo), macrociclo);
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            return false;
        }
    }
}