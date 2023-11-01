/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Microciclo;
import fachada.FachadaDatos;
import interfaces.IDatos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Yorsh
 */
public class MicrocicloController {
    
    private final IDatos fachadaDatos;
    
    public MicrocicloController() {
        this.fachadaDatos = new FachadaDatos();
    }
    
    public boolean guardarMicrociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclo) {
        try {
            return this.fachadaDatos.guardarMicrociclos(idMacrociclo, idMesociclo, microciclo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}