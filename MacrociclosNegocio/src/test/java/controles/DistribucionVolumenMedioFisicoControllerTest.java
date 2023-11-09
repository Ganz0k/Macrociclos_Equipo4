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

/**
 *
 * @author luisg
 */
public class DistribucionVolumenMedioFisicoControllerTest {
    
    @Test
    public void testGuardarVolumenesMediosFisicosEnMesociclo() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        assertTrue(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }
    
    @Test
    public void testIdMacrocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        assertFalse(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }

    @Test
    public void testIdMesocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);

        assertFalse(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME));
    }

    @Test
    public void testTiraNegocioExceptionPorNulls() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = null;
        ObjectId idMesociclo = null;
        VolumenMedioFisico vME = null;

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testTiraNegocioExceptionPorUnNull() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId();
        VolumenMedioFisico vME = null;

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testTiraNegocioExceptionSiAtributosDeDistribucionSonNull() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(null, null, 72.64705882f, 95f);

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }

    @Test
    public void testTiraNegocioExceptionSiAtributosDeDistribucionSonNegativos() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");
        VolumenMedioFisico vME = new VolumenMedioFisico(new ObjectId(), new ObjectId(), -72.64705882f, -95f);

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, vME);
        });
    }
    
    @Test
    public void testEliminarDistribucionesVolumen() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        assertTrue(dVMEC.eliminarDistribuciones(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId();
        
        assertFalse(dVMEC.eliminarDistribuciones(idMacrociclo));
    }
    
    @Test
    public void testTiraNegocioExceptionSiIdNulo() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = null;
        
        assertThrows(NegocioException.class, () -> {
            dVMEC.eliminarDistribuciones(idMacrociclo);
        });
    }
}
