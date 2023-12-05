/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import entidades.Macrociclo;
import entidades.Mesociclo;
import enumeradores.Etapa;
import enumeradores.Rama;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
public class MacrocicloControllerTest {

    @Test
    public void testGuardarMacrociclo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);

        when(mC.guardarMacrociclo(macrociclo)).thenReturn(true);
        
        assertTrue(mC.guardarMacrociclo(macrociclo));
    }
    
    @Test
    public void testGuardarMacroNulo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        when(mC.guardarMacrociclo(null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(null);
        });
    }
    
    @Test
    public void testGuardarCamposNulos() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);
        
        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, null, "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
        
        when(mC.guardarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testGuardarMenosDe20Semanas() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 10, 6).getTime(), 
                new GregorianCalendar(2023, 10, 10).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
        
        when(mC.guardarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testGuardarFechaAnioMenorAlActual() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2015, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.guardarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testGuardarFechaFinMenorAFechaInicio() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2023, 8, 1).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.guardarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testGuardarSumaSemanasNoIgualATotalSemanas() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.guardarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMacrociclo(macrociclo);
        });
    }

    @Test
    public void testObtenerMacrociclo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId("654dd6835b04545e539ab919"), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.obtenerMacrociclo(macrociclo.getId())).thenReturn(macrociclo);
        
        assertEquals(macrociclo, mC.obtenerMacrociclo(macrociclo.getId()));
    }
    
    @Test
    public void testObtenerIdNulo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        when(mC.obtenerMacrociclo(null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.obtenerMacrociclo(null);
        });
    }
    
    @Test
    public void testObtenerIdFalso() {
        MacrocicloController mC = mock(MacrocicloController.class);
        ObjectId id = new ObjectId();
        when(mC.obtenerMacrociclo(id)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.obtenerMacrociclo(id);
        });
    }
    
    @Test
    public void testActualizarMacrociclo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);

        when(mC.actualizarMacrociclo(macrociclo)).thenReturn(true);
        
        assertTrue(mC.actualizarMacrociclo(macrociclo));
    }
    
    @Test
    public void testActualizarMacroNulo() {
        MacrocicloController mC = mock(MacrocicloController.class);
        when(mC.actualizarMacrociclo(null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(null);
        });
    }
    
    @Test
    public void testActualizarCamposNulos() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);
        
        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, null, "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
        
        when(mC.actualizarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testActualizarMenosDe20Semanas() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 10, 6).getTime(), 
                new GregorianCalendar(2023, 10, 10).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
        
        when(mC.actualizarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testActualizarFechaAnioMenorAlActual() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2015, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.actualizarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testActualizarFechaFinMenorAFechaInicio() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 6, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2023, 8, 1).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.actualizarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testActualizarSumaSemanasNoIgualATotalSemanas() {
        MacrocicloController mC = mock(MacrocicloController.class);
        List<Mesociclo> listaM = new ArrayList<>();

        Mesociclo m1 = new Mesociclo(new ObjectId(), 1, Etapa.GENERAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m2 = new Mesociclo(new ObjectId(), 2, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m3 = new Mesociclo(new ObjectId(), 3, Etapa.GENERAL, 5, new ArrayList<>(), new ArrayList<>());
        Mesociclo m4 = new Mesociclo(new ObjectId(), 4, Etapa.GENERAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m5 = new Mesociclo(new ObjectId(), 5, Etapa.ESPECIAL, 4, new ArrayList<>(), new ArrayList<>());
        Mesociclo m6 = new Mesociclo(new ObjectId(), 6, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m7 = new Mesociclo(new ObjectId(), 7, Etapa.ESPECIAL, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m8 = new Mesociclo(new ObjectId(), 8, Etapa.COMPETITIVA, 3, new ArrayList<>(), new ArrayList<>());
        Mesociclo m9 = new Mesociclo(new ObjectId(), 9, Etapa.COMPETITIVA, 2, new ArrayList<>(), new ArrayList<>());

        listaM.add(m1);
        listaM.add(m2);
        listaM.add(m3);
        listaM.add(m4);
        listaM.add(m5);
        listaM.add(m6);
        listaM.add(m7);
        listaM.add(m8);
        listaM.add(m9);

        Macrociclo macrociclo = new Macrociclo(new ObjectId(), new ObjectId("65415812c421fde5b6f9cc9b"),
                "En tránsito", "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 0, 5, new ArrayList<>(), listaM);
    
        when(mC.actualizarMacrociclo(macrociclo)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.actualizarMacrociclo(macrociclo);
        });
    }
    
    @Test
    public void testActualizarStatus() {
        MacrocicloController mC = mock(MacrocicloController.class);
        ObjectId id = new ObjectId("655865f6f665d001664ce76c");
        
        when(mC.actualizarStatus(id, "Aprobado")).thenReturn(true);
        
        assertTrue(mC.actualizarStatus(id, "Aprobado"));
    }
    
    @Test
    public void testActualizarStatusIdFalso() {
        MacrocicloController mC = mock(MacrocicloController.class);
        ObjectId id = new ObjectId();
        
        when(mC.actualizarStatus(id, "No aprobado")).thenReturn(false);
        
        assertFalse(mC.actualizarStatus(id, "No aprobado"));
    }
}
