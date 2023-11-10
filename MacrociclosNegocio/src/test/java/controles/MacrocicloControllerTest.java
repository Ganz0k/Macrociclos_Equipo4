/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controles;

import entidades.Macrociclo;
import entidades.Mesociclo;
import enumeradores.Etapa;
import enumeradores.Rama;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author luisg
 */
public class MacrocicloControllerTest {

    @Test
    public void testGuardarMacrociclo() {
        MacrocicloController mC = new MacrocicloController();
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
                "Judo", Rama.MIXTO, "Ana Nayeli Leon", "Luis Gerardo Miranda",
                "Benjamin Murrieta", new GregorianCalendar(2023, 8, 4).getTime(), 
                new GregorianCalendar(2024, 0, 19).getTime(), 20, 10, 5, new ArrayList<>(), listaM);

        assertTrue(mC.guardarMacrociclo(macrociclo));
    }

    @Test
    public void testObtenerMacrociclo() {
        
    }
}
