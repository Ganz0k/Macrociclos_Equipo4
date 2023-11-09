/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.VolumenMedioFisico;
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
        VolumenMedioFisicoDAO dVMFDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        
        assertTrue(dVMFDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testGuardarIdMacrocicloFalso() {
        VolumenMedioFisicoDAO dVMFDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        
        assertFalse(dVMFDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testGuardarIdMesocicloFalso() {
        VolumenMedioFisicoDAO dVMFDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        
        assertFalse(dVMFDAO.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testEliminarDistribucionesVolumen() {
        VolumenMedioFisicoDAO dVMFDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        assertTrue(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdFalso() {
        VolumenMedioFisicoDAO dVMFDAO = new VolumenMedioFisicoDAO();
        ObjectId idMacrociclo = new ObjectId();
        
        assertFalse(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo));
    }
}
