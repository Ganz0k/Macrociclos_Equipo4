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
import entidades.MedioFisico;
import excepciones.PersistenciaException;
import java.util.List;
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

    private MongoCollection<Macrociclo> getColeccion() {
        return this.baseDatos.getCollection("macrociclos", Macrociclo.class);
    }

    public boolean actualizarMediosFisicos(ObjectId idMacrociclo, List<MedioFisico> mediosFisicos) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();

            if (macrociclo != null) {
                macrociclo.setMediosFisicos(mediosFisicos);
                Macrociclo m = coleccion.findOneAndReplace(Filters.eq("_id", idMacrociclo), macrociclo);
                
                return m != null;
            }
            
            return false;
        } catch (Exception e) {
            throw new PersistenciaException(e.getMessage(), e.getCause());
        }
    }
}
