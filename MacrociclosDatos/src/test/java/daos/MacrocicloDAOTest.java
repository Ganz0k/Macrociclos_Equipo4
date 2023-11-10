/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import entidades.Macrociclo;
import enumeradores.Rama;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author luisg
 */
public class MacrocicloDAOTest {

    @Test
    public void testCrearMacrociclo() {
        MacrocicloDAO mDAO = new MacrocicloDAO();
        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"), 
                "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda", 
                "Benjamin Murrieta", new Date(), new Date(), 10, 15,
                5, new ArrayList<>(), new ArrayList<>());
        
        assertTrue(mDAO.guardarMacrociclo(macrociclo));
    }

    @Test
    public void testCrearNulo() {
        MacrocicloDAO mDAO = new MacrocicloDAO();
        assertFalse(mDAO.guardarMacrociclo(null));
    }

    @Test
    public void testObtenerMacrociclo() {
        MacrocicloDAO mDAO = new MacrocicloDAO();
        Macrociclo macrociclo = new Macrociclo(new ObjectId("654d2fcecd715f27d022df2a"), new ObjectId("65415812c421fde5b6f9cc9b"), 
                "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda", 
                "Benjamin Murrieta", new Date(), new Date(), 10, 15,
                5, new ArrayList<>(), new ArrayList<>());
        
        assertEquals(macrociclo, mDAO.obtenerMacrociclo(macrociclo.getId())); 
    }
    
    @Test
    public void testObtenerIdFalso() {
        MacrocicloDAO mDAO = new MacrocicloDAO();
        
        assertEquals(null, mDAO.obtenerMacrociclo(new ObjectId()));
    }   
}
