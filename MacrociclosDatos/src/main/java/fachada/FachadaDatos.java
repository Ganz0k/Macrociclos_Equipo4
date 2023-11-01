/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import daos.MicrocicloDAO;
import daos.VolumenMedioFisicoDAO;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import interfaces.IDatos;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class FachadaDatos implements IDatos {
    
    private final MicrocicloDAO microcicloDAO;
    private final VolumenMedioFisicoDAO volumenMedioFisicoDAO;
    
    public FachadaDatos() {
        this.microcicloDAO = new MicrocicloDAO();
        this.volumenMedioFisicoDAO = new VolumenMedioFisicoDAO();
    }

    @Override
    public boolean guardarVolumenesMediosFisicosEnMesociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<VolumenMedioFisico> volumenesMediosFisicos) {
        return this.volumenMedioFisicoDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, volumenesMediosFisicos);
    }

    @Override
    public boolean guardarMicrociclos(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) {
        return this.microcicloDAO.guardarMicrociclos(idMacrociclo, idMesociclo, microciclos);
    }
    
}
