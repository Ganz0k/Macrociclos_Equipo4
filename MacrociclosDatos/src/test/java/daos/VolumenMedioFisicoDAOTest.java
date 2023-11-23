/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.VolumenMedioFisico;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisg
 */
public class VolumenMedioFisicoDAOTest {

    @Test
    public void testActualizarVolumenesMediosFisicosEnMesociclo() {
        VolumenMedioFisicoDAO dVMFDAO = mock(VolumenMedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        
        when(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(true);
        
        assertTrue(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testActualizarIdMacrocicloFalso() {
        VolumenMedioFisicoDAO dVMFDAO = mock(VolumenMedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);

        when(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(false);
        
        assertFalse(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testActualizarIdMesocicloFalso() {
        VolumenMedioFisicoDAO dVMFDAO = mock(VolumenMedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 65f, 85f);
        
        when(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(false);
        
        assertFalse(dVMFDAO.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testEliminarDistribucionesVolumen() {
        VolumenMedioFisicoDAO dVMFDAO = mock(VolumenMedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo)).thenReturn(true);
        
        assertTrue(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdFalso() {
        VolumenMedioFisicoDAO dVMFDAO = mock(VolumenMedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId();
        
        when(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo)).thenReturn(false);
        
        assertFalse(dVMFDAO.eliminarDistribucionesVolumenes(idMacrociclo));
    }
}
