/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import daos.MicrocicloDAO;
import entidades.Microciclo;
import org.bson.types.ObjectId;

/**
 *
 * @author Yorsh
 */
public class MicrocicloController {
    
    private final MicrocicloDAO microcicloDAO;
    
    public MicrocicloController() {
        this.microcicloDAO = new MicrocicloDAO();
    }
    
    public boolean guardarMicrociclo(Microciclo microciclo) {
        try {
            if(microcicloDAO.guardarMicrociclo(microciclo)){
                
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public Microciclo buscarMicrocicloPorId(ObjectId id) {
        try {
            Microciclo microciclo = microcicloDAO.buscarMicrocicloPorId(id);
            return microciclo;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }        
    }
    
    public boolean eliminarMicrociclo(ObjectId id) {
        return microcicloDAO.eliminarMicrociclo(id);
    }
}