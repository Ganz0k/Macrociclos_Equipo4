/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.VolumenMedioFisico;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luisg
 */
public class VolumenMedioFisicoDAOTest {

    @Test
    public void testGuardarVolumenesMediosFisicosEnMesociclo() {
        VolumenMedioFisicoDAO dVMEDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        
        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 255.5443548f, 65f);
        
        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);
        
        assertTrue(dVMEDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }
    
    @Test
    public void testIdMacrocicloFalso() {
        VolumenMedioFisicoDAO dVMEDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        
        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 255.5443548f, 65f);
        
        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);
        
        assertFalse(dVMEDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }
    
    @Test
    public void testIdMesocicloFalso() {
        VolumenMedioFisicoDAO dVMEDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        
        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 255.5443548f, 65f);
        
        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);
        
        assertFalse(dVMEDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }
}
