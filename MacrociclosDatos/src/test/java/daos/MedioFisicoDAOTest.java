/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.MedioFisico;
import enumeradores.Etapa;
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
public class MedioFisicoDAOTest {
    
    @Test
    public void testGuardarMediosFisicos() {
        MedioFisicoDAO dao = mock(MedioFisicoDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        List<MedioFisico> lista = new ArrayList<>();
        lista.add(new MedioFisico(new ObjectId(), "Fuerza", Etapa.GENERAL, 5, 10, 20f, 2, 10f));
        
        when(dao.guardarMediosFisicos(idMacrociclo, lista)).thenReturn(true);
        
        assertTrue(dao.guardarMediosFisicos(idMacrociclo, lista));
    }
    
    @Test
    public void testGuardarIdFalso() {
        MedioFisicoDAO dao = mock(MedioFisicoDAO.class);
        ObjectId id = new ObjectId();
        List<MedioFisico> lista = new ArrayList<>();
        lista.add(new MedioFisico(new ObjectId(), "Fuerza", Etapa.GENERAL, 5, 10, 20f, 2, 10f));
        
        when(dao.guardarMediosFisicos(id, lista)).thenReturn(false);
        
        assertFalse(dao.guardarMediosFisicos(id, lista));
    }
}
