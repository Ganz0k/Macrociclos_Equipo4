/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.Macrociclo;
import enumeradores.Rama;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import org.bson.types.ObjectId;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author luisg
 */
public class MacrocicloDAOTest {

    @Test
    public void testCrearMacrociclo() {
        MacrocicloDAO mDAO = mock(MacrocicloDAO.class);
        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"), 
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda", 
                "Benjamin Murrieta", new Date(), new Date(), 10, 15,
                5, new ArrayList<>(), new ArrayList<>());
        
        when(mDAO.guardarMacrociclo(macrociclo)).thenReturn(true);
        
        assertTrue(mDAO.guardarMacrociclo(macrociclo));
    }

    @Test
    public void testCrearNulo() {
        MacrocicloDAO mDAO = mock(MacrocicloDAO.class);
        when(mDAO.guardarMacrociclo(null)).thenReturn(false);
        assertFalse(mDAO.guardarMacrociclo(null));
    }

    @Test
    public void testObtenerMacrociclo() {
        MacrocicloDAO mDAO = mock(MacrocicloDAO.class);
        Macrociclo macrociclo = new Macrociclo(new ObjectId("655865f6f665d001664ce76c"), new ObjectId("65415812c421fde5b6f9cc9b"), 
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda", 
                "Benjamin Murrieta", new Date(), new Date(), 10, 15,
                5, new ArrayList<>(), new ArrayList<>());
        
        when(mDAO.obtenerMacrociclo(macrociclo.getId())).thenReturn(macrociclo);
        
        assertEquals(macrociclo, mDAO.obtenerMacrociclo(macrociclo.getId())); 
    }
    
    @Test
    public void testObtenerIdFalso() {
        MacrocicloDAO mDAO = mock(MacrocicloDAO.class);
        when(mDAO.obtenerMacrociclo(null)).thenReturn(null);
        
        assertEquals(null, mDAO.obtenerMacrociclo(new ObjectId()));
    }
}
