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
    public void testGuardarMediosFisicos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        List<MedioFisico> lista = new ArrayList<>();
        lista.add(new MedioFisico(new ObjectId(), "Fuerza", Etapa.GENERAL, 5, 10, 20f, 2, 10f));
        
        when(controller.guardarMediosFisicos(idMacrociclo, lista)).thenReturn(true);
        
        assertTrue(controller.guardarMediosFisicos(idMacrociclo, lista));
    }
    
    @Test
    public void testGuardarNulos() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        when(controller.guardarMediosFisicos(null, null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.guardarMediosFisicos(null, null);
        });
    }
    
    @Test
    public void testGuardarListaVacia() {
        MedioFisicoController controller = mock(MedioFisicoController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(controller.guardarMediosFisicos(idMacrociclo, new ArrayList<>())).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            controller.guardarMediosFisicos(idMacrociclo, new ArrayList<>());
        });
    }
}
