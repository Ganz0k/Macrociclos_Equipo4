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
import entidades.VolumenMedioFisico;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class VolumenMedioFisicoDAO {

    private final MongoDatabase baseDatos;

    public VolumenMedioFisicoDAO() {
        this.baseDatos = ConexionBD.crearConexion();
    }

    private MongoCollection<Macrociclo> getColeccion() {
        return this.baseDatos.getCollection("macrociclos", Macrociclo.class);
    }

    public boolean actualizarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, VolumenMedioFisico volumenMedioFisico) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();

            if (macrociclo != null) {
                List<Mesociclo> mesociclos = macrociclo.getMesociclos();

                for (int i = 0; i < mesociclos.size(); i++) {
                    if (mesociclos.get(i).getId().equals(idMesociclo)) {
                        mesociclos.get(i).getDistribucionVolumen().add(volumenMedioFisico);
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
    
    public boolean eliminarDistribucionesVolumenes(ObjectId idMacrociclo) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();
            
            if (macrociclo != null) {
                for (int i = 0; i < macrociclo.getMesociclos().size(); i++) {
                    macrociclo.getMesociclos().get(i).setDistribucionVolumen(new ArrayList<>());
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
