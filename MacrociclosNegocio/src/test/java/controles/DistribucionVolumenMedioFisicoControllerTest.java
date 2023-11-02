/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import org.junit.jupiter.api.Test;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.List;
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

            VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);
            VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 275.2016129f, 70f);

        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);

        assertTrue(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }
    
    @Test
    public void testIdMacrocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");

        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 275.2016129f, 70f);

        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);

        assertFalse(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }

    @Test
    public void testIdMesocicloFalso() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();

        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 72.64705882f, 95f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId("654316cc0a1d7b2556805a55"), 275.2016129f, 70f);

        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);

        assertFalse(dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME));
    }

    @Test
    public void testTiraNegocioExceptionPorNulls() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = null;
        ObjectId idMesociclo = null;
        List<VolumenMedioFisico> listaVME = null;

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME);
        });
    }

    @Test
    public void testTiraNegocioExceptionPorUnNull() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId();
        List<VolumenMedioFisico> listaVME = null;

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME);
        });
    }

    @Test
    public void testTiraNegocioExceptionSiAtributosDeElementosDeListaSonNull() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");

        VolumenMedioFisico vME1 = new VolumenMedioFisico(null, null, 72.64705882f, 95f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(null, null, 275.2016129f, 70f);

        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME);
        });
    }

    @Test
    public void testTiraNegocioExceptionSiAtributosDeElementosDeListaSonNegativos() {
        DistribucionVolumenMedioFisicoController dVMEC = new DistribucionVolumenMedioFisicoController();
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba280");

        VolumenMedioFisico vME1 = new VolumenMedioFisico(new ObjectId(), new ObjectId(), -72.64705882f, -95f);
        VolumenMedioFisico vME2 = new VolumenMedioFisico(new ObjectId(), new ObjectId(), -275.2016129f, -70f);

        List<VolumenMedioFisico> listaVME = new LinkedList<>();
        listaVME.add(vME1);
        listaVME.add(vME2);

        assertThrows(NegocioException.class, () -> {
            dVMEC.guardarVolumenesMediosFisicosEnMesociclo(idMacrociclo, idMesociclo, listaVME);
        });
    }
}
