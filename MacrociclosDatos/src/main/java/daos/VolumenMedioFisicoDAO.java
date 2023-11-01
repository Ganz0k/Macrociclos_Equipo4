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

    public boolean guardarVolumenMedioFisicoEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) {
        try {
            MongoCollection<Macrociclo> coleccion = this.getColeccion();
            Macrociclo macrociclo = coleccion.find(Filters.eq("_id", idMacrociclo)).first();

            if (macrociclo != null) {
                List<Mesociclo> mesociclos = macrociclo.getMesociclos();

                for (int i = 0; i < mesociclos.size(); i++) {
                    if (mesociclos.get(i).getId().equals(idMesociclo)) {
                        mesociclos.get(i).setDistribucionVolumen(volumenesMediosFisicos);
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
