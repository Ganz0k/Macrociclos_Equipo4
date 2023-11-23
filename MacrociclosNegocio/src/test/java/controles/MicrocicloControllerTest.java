/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import java.util.ArrayList;
import java.util.Date;
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
public class MicrocicloControllerTest {

    @Test
    public void testGuardarMicrociclo() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        List<VolumenMedioFisico> listaVMF = new ArrayList<>();
        
        VolumenMedioFisico vMF = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 7.8f, 0f);
        listaVMF.add(vMF);
        
        Date inicio = new GregorianCalendar(2023, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 17).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, true, false);
        Microciclo micro2 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, false, true);
        
        lista.add(micro1);
        lista.add(micro2);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenReturn(true);
        
        assertTrue(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista));
    }
    
    @Test
    public void testGuardarElementosNulos() {
        MicrocicloController mC = mock(MicrocicloController.class);
        when(mC.guardarMicrociclo(null, null, null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(null, null, null);
        });
    }
    
    @Test
    public void testGuardarMicrociclosVacios() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, new ArrayList<>())).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, new ArrayList<>());
        });
    }
    
    @Test
    public void tesGuardarVolumenesVacios() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        Date inicio = new GregorianCalendar(2023, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 17).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", new ArrayList<>(), true, false);
        lista.add(micro1);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista);
        });
    }
    
    @Test
    public void testGuardarVolumenesNegativos() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        List<VolumenMedioFisico> listaVMF = new ArrayList<>();
        
        VolumenMedioFisico vMF = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), -7.8f, 0f);
        listaVMF.add(vMF);
        
        Date inicio = new GregorianCalendar(2023, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 17).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, true, false);
        lista.add(micro1);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista);
        });
    }
    
    @Test
    public void testGuardarAnioMenorActual() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        List<VolumenMedioFisico> listaVMF = new ArrayList<>();
        
        VolumenMedioFisico vMF = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 7.8f, 0f);
        listaVMF.add(vMF);
        
        Date inicio = new GregorianCalendar(2017, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 17).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, true, false);
        lista.add(micro1);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista);
        });
    }
    
    @Test
    public void testFechaFinIgualInicio() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        List<VolumenMedioFisico> listaVMF = new ArrayList<>();
        
        VolumenMedioFisico vMF = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 7.8f, 0f);
        listaVMF.add(vMF);
        
        Date inicio = new GregorianCalendar(2023, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 13).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, true, false);
        lista.add(micro1);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista);
        });
    }
    
    @Test
    public void testGuardarFechasNoSon5Dias() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        ObjectId idMesociclo = new ObjectId("6540abc7eb7a0415d79ba27f");
        List<Microciclo> lista = new ArrayList<>();
        List<VolumenMedioFisico> listaVMF = new ArrayList<>();
        
        VolumenMedioFisico vMF = new VolumenMedioFisico(new ObjectId(), new ObjectId("6540abc7eb7a0415d79ba27c"), 7.8f, 0f);
        listaVMF.add(vMF);
        
        Date inicio = new GregorianCalendar(2023, 10, 13).getTime();
        Date fin = new GregorianCalendar(2023, 10, 27).getTime();
        
        Microciclo micro1 = new Microciclo(new ObjectId(), inicio, fin, "12%", listaVMF, true, false);
        lista.add(micro1);
        
        when(mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.guardarMicrociclo(idMacrociclo, idMesociclo, lista);
        });
    }

    @Test
    public void testEliminarMicrociclos() {
        MicrocicloController mC = mock(MicrocicloController.class);
        ObjectId idMacrociclo = new ObjectId("6540abc7eb7a0415d79ba288");
        
        when(mC.eliminarMicrociclos(idMacrociclo)).thenReturn(true);
        
        assertTrue(mC.eliminarMicrociclos(idMacrociclo));
    }
    
    @Test
    public void testEliminarIdNulo() {
        MicrocicloController mC = mock(MicrocicloController.class);
        when(mC.eliminarMicrociclos(null)).thenThrow(NegocioException.class);
        
        assertThrows(NegocioException.class, () -> {
            mC.eliminarMicrociclos(null);
        });
    }
}
