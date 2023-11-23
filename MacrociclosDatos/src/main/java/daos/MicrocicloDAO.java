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
import excepciones.PersistenciaException;
import java.util.ArrayList;
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
    
    public boolean actualizarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
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
                    
                    if (i == mesociclos.size() - 1) {
                        return false;
                    }
                }
                
                Macrociclo m = coleccion.findOneAndReplace(Filters.eq("_id", idMacrociclo), macrociclo);
                return m != null;
            }
            
            return false;
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
    
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();
            
            if (macrociclo != null) {
                for (int i = 0; i < macrociclo.getMesociclos().size(); i++) {
                    macrociclo.getMesociclos().get(i).setMicrociclos(new ArrayList<>());
                }
                
                coleccion.findOneAndReplace(Filters.eq("_id", idMacrociclo), macrociclo);
                return true;
            }
            
            return false;
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
}
