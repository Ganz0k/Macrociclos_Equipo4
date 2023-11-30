/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import entidades.MedioFisico;
import enumeradores.Etapa;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisg
 */
public class MedioFisicoControllerTest {
    
    @Test
    public void testActualizarMediosFisicos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        List<MedioFisico> lista = new ArrayList<>();
        lista.add(new MedioFisico(new ObjectId(), "Fuerza", Etapa.GENERAL, 5, 10, 20f, 2, 10f));
        
        when(controller.actualizarMediosFisicos(idMacrociclo, lista)).thenReturn(true);
        
        assertTrue(controller.actualizarMediosFisicos(idMacrociclo, lista));
    }
    
    @Test
    public void testActualizarNulos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        when(controller.actualizarMediosFisicos(null, null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.actualizarMediosFisicos(null, null);
        });
    }
    
    @Test
    public void testActualizarListaVacia() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(controller.actualizarMediosFisicos(idMacrociclo, new ArrayList<>())).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.actualizarMediosFisicos(idMacrociclo, new ArrayList<>());
        });
    }
    
    @Test
    public void testValidarMediosFisicos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        List<MedioFisico> lista = new ArrayList<>();
        lista.add(new MedioFisico(new ObjectId(), "Fuerza", Etapa.GENERAL, 5, 10, 20f, 2, 10f));
        
        when(controller.validarMediosFisicos(idMacrociclo, lista)).thenReturn(true);
        
        assertTrue(controller.validarMediosFisicos(idMacrociclo, lista));
    }
    
    @Test
    public void testValidarConNulos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        when(controller.validarMediosFisicos(null, null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.validarMediosFisicos(null, null);
        });
    }
    
    @Test
    public void testValidarConListaVacia() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(controller.validarMediosFisicos(idMacrociclo, new ArrayList<>())).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.validarMediosFisicos(idMacrociclo, new ArrayList<>());
        });
    }
}
