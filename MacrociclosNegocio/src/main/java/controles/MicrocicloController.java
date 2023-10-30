/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import com.mongodb.client.MongoDatabase;
import daos.MicrocicloDAO;
import entidades.Microciclo;
import org.bson.types.ObjectId;

/**
 *
 * @author Yorsh
 */
public class MicrocicloController {

    private final MicrocicloDAO microcicloDAO;

    public MicrocicloController(MongoDatabase database) {
        this.microcicloDAO = new MicrocicloDAO(database);
    }

    public boolean insertMicrociclo(Microciclo microciclo) {
        try {
            // Validación: Asegurarse de que no exista un Microciclo con el mismo ID
            if (microcicloDAO.findMicrocicloById(microciclo.getId()) != null) {
                return false; // El Microciclo ya existe
            }

            microcicloDAO.insertMicrociclo(microciclo);
            return true; // Inserción exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error al insertar el Microciclo
        }
    }

    public Microciclo findMicrocicloById(ObjectId id) {
        try {
            return microcicloDAO.findMicrocicloById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Error al buscar el Microciclo
        }
    }

    public boolean updateMicrociclo(Microciclo microciclo) {
        try {
            // Validación: Asegurarse de que el Microciclo exista antes de actualizar
            if (microcicloDAO.findMicrocicloById(microciclo.getId()) == null) {
                return false; // El Microciclo no existe
            }

            microcicloDAO.updateMicrociclo(microciclo);
            return true; // Actualización exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error al actualizar el Microciclo
        }
    }

    public boolean deleteMicrociclo(ObjectId id) {
        try {
            // Validación: Asegurarse de que el Microciclo exista antes de eliminar
            if (microcicloDAO.findMicrocicloById(id) == null) {
                return false; // El Microciclo no existe
            }

            microcicloDAO.deleteMicrociclo(id);
            return true; // Eliminación exitosa
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Error al eliminar el Microciclo
        }
    }

    // Puedes agregar métodos adicionales aquí para realizar operaciones específicas de la aplicación.
}


