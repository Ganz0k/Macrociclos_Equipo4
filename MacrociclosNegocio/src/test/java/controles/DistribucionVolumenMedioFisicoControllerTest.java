/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import org.junit.jupiter.api.Test;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import static org.junit.jupiter.api.Assertions.*;
import org.bson.types.ObjectId;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisg
 */
public class DistribucionVolumenMedioFisicoControllerTest {
    
    @Test
    public void testActualizarVolumenesMediosFisicosEnMesociclo() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(true);
        
        assertTrue(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testActualizarIdMacrocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(false);
        
        assertFalse(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }

    @Test
    public void testActualizarIdMesocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenReturn(false);
        
        assertFalse(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }

    @Test
    public void testActualizarTiraNegocioExceptionPorNulls() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = null;
        ObjectId idMesociclo = null;
        VolumenMedioFisico vME = null;
        
        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenThrow(NegocioException.class);

        assertThrows(NegocioException.class, () -> {
            dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testActualizarTiraNegocioExceptionPorUnNull() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = null;
        
        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenThrow(NegocioException.class);

        assertThrows(NegocioException.class, () -> {
            dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testActualizarTiraNegocioExceptionSiAtributosDeDistribucionSonNull() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(null, null, 72.64705882f, 95f);

        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testActualizarTiraNegocioExceptionSiAtributosDeDistribucionSonNegativos() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId(), -72.64705882f, -95f);

        when(dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            dVMEC.actualizarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }
    
    @Test
    public void testEliminarDistribucionesVolumen() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(dVMEC.eliminarDistribuciones(idMacrociclo)).thenReturn(true);
        
        assertTrue(dVMEC.eliminarDistribuciones(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId();
        
        when(dVMEC.eliminarDistribuciones(idMacrociclo)).thenReturn(false);
        
        assertFalse(dVMEC.eliminarDistribuciones(idMacrociclo));
    }
    
    @Test
    public void testTiraNegocioExceptionSiIdNulo() {
        DistribucionVolumenMedioFisicoController dVMEC = mock(DistribucionVolumenMedioFisicoController.class);
        ObjectId idMacrociclo = null;
        
        when(dVMEC.eliminarDistribuciones(idMacrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            dVMEC.eliminarDistribuciones(idMacrociclo);
        });
    }
}
