/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.Microciclo;
import java.util.ArrayList;
import java.util.Date;
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
public class MicrocicloDAOTest {
    
    @Test
    public void testActualizarMicrociclos() {
        MicrocicloDAO mDAO = mock(MicrocicloDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> microciclos = new ArrayList<>();
        
        for (int i = 0; i < 6; i++) {
            microciclos.add(new Microciclo(new ObjectId(), new Date(), new Date(), "12%", new ArrayList<>(), false, true));
        }
        
        when(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos)).thenReturn(true);
        
        assertTrue(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos));
    }
    
    @Test
    public void testActualizarIdMacrocicloFalso() {
        MicrocicloDAO mDAO = mock(MicrocicloDAO.class);
        ObjectId idMacrociclo = new ObjectId();
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> microciclos = new ArrayList<>();
        
        for (int i = 0; i < 6; i++) {
            microciclos.add(new Microciclo(new ObjectId(), new Date(), new Date(), "12%", new ArrayList<>(), false, true));
        }
        
        when(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos)).thenReturn(false);
        
        assertFalse(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos));
    }
    
    @Test
    public void testActualizarIdMesocicloFalso() {
        MicrocicloDAO mDAO = mock(MicrocicloDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId();
        List<Microciclo> microciclos = new ArrayList<>();
        
        for (int i = 0; i < 6; i++) {
            microciclos.add(new Microciclo(new ObjectId(), new Date(), new Date(), "12%", new ArrayList<>(), false, true));
        }
        
        when(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos)).thenReturn(false);
        
        assertFalse(mDAO.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos));
    }

    @Test
    public void testEliminarMicrociclos() {
        MicrocicloDAO mDAO = mock(MicrocicloDAO.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(mDAO.eliminarMicrociclos(idMacrociclo)).thenReturn(true);
        
        assertTrue(mDAO.eliminarMicrociclos(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdMacrocicloFalso() {
        MicrocicloDAO mDAO = mock(MicrocicloDAO.class);
        ObjectId idMacrociclo = new ObjectId();
        
        when(mDAO.eliminarMicrociclos(idMacrociclo)).thenReturn(false);
        
        assertFalse(mDAO.eliminarMicrociclos(idMacrociclo));
    }
}
