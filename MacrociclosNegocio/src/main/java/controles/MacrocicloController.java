/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Macrociclo;
import entidades.Mesociclo;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachada.FachadaDatos;
import interfaces.IDatos;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class MacrocicloController {
    
    private final IDatos fachadaDatos;

    public MacrocicloController() {
        this.fachadaDatos = new FachadaDatos();
    }

    public boolean guardarMacrociclo(Macrociclo macrociclo) throws PersistenciaException {
        if (macrociclo == null) {
            throw new NegocioException("Mande un macrociclo");
        }

        if (macrociclo.getDeporte() == null || macrociclo.getRama() == null || macrociclo.getJefeRama() == null || macrociclo.getEntrenadorAuxiliar() == null || macrociclo.getMetodologo() == null) {
            throw new NegocioException("Todos los campos deben de tener valor");
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(macrociclo.getFechaInicio());
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(macrociclo.getFechaFin());
        
        int weekdays = 0;
        
        while (cal1.before(cal2) || cal1.equals(cal2)) {
            int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
            
            if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                weekdays++;
            }
            
            cal1.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        int semanas = weekdays / 5;

        if (semanas < 20 || semanas > 52) {
            throw new NegocioException("El total de semanas de un macrociclo debe ser de mínimo 20 semanas o máximo 52 semanas");
        }
            
        GregorianCalendar anioActualC = new GregorianCalendar();
        anioActualC.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        anioActualC.set(GregorianCalendar.DAY_OF_MONTH, 1);
        anioActualC.set(GregorianCalendar.HOUR_OF_DAY, 0);
        anioActualC.set(GregorianCalendar.MINUTE, 0);
        anioActualC.set(GregorianCalendar.SECOND, 0);
        anioActualC.set(GregorianCalendar.MILLISECOND, 0);
        
        Date anioActual = anioActualC.getTime();

        if (macrociclo.getFechaInicio().before(anioActual) || macrociclo.getFechaFin().before(anioActual)) {
            throw new NegocioException("Las fechas no pueden ser de años anteriores al actual");
        }

        if (macrociclo.getFechaInicio().getTime() >= macrociclo.getFechaFin().getTime()) {
            throw new NegocioException("La fecha de fin no puede ser menor o igual a la de inicio");
        }

        int contadorSemanas = 0;
        int totalSemanas = macrociclo.getSemanasGeneral() + macrociclo.getSemanasEspecial() + macrociclo.getSemanasPrecompetitivo() + macrociclo.getSemanasCompetitivo();

        for (Mesociclo m : macrociclo.getMesociclos()) {
            contadorSemanas += m.getNumSemanas();
        }

        if (contadorSemanas != totalSemanas) {
            throw new NegocioException("La suma de las semanas de los mesociclos debe de ser igual al total de semanas del macrociclo");
        }

        return this.fachadaDatos.guardarMacrociclo(macrociclo);
    }
    
    public boolean actualizarMacrociclo(Macrociclo macrociclo) throws PersistenciaException {
        if (macrociclo == null) {
            throw new NegocioException("Mande un macrociclo");
        }

        if (macrociclo.getDeporte() == null || macrociclo.getRama() == null || macrociclo.getJefeRama() == null || macrociclo.getEntrenadorAuxiliar() == null || macrociclo.getMetodologo() == null) {
            throw new NegocioException("Todos los campos deben de tener valor");
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(macrociclo.getFechaInicio());
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(macrociclo.getFechaFin());
        
        int weekdays = 0;
        
        while (cal1.before(cal2) || cal1.equals(cal2)) {
            int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
            
            if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                weekdays++;
            }
            
            cal1.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        int semanas = weekdays / 5;

        if (semanas < 20 || semanas > 52) {
            throw new NegocioException("El total de semanas de un macrociclo debe ser de mínimo 20 semanas o máximo 52 semanas");
        }
            
        GregorianCalendar anioActualC = new GregorianCalendar();
        anioActualC.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
        anioActualC.set(GregorianCalendar.DAY_OF_MONTH, 1);
        anioActualC.set(GregorianCalendar.HOUR_OF_DAY, 0);
        anioActualC.set(GregorianCalendar.MINUTE, 0);
        anioActualC.set(GregorianCalendar.SECOND, 0);
        anioActualC.set(GregorianCalendar.MILLISECOND, 0);
        
        Date anioActual = anioActualC.getTime();

        if (macrociclo.getFechaInicio().before(anioActual) || macrociclo.getFechaFin().before(anioActual)) {
            throw new NegocioException("Las fechas no pueden ser de años anteriores al actual");
        }

        if (macrociclo.getFechaInicio().getTime() >= macrociclo.getFechaFin().getTime()) {
            throw new NegocioException("La fecha de fin no puede ser menor o igual a la de inicio");
        }

        int contadorSemanas = 0;
        int totalSemanas = macrociclo.getSemanasGeneral() + macrociclo.getSemanasEspecial() + macrociclo.getSemanasCompetitivo();

        for (Mesociclo m : macrociclo.getMesociclos()) {
            contadorSemanas += m.getNumSemanas();
        }

        if (contadorSemanas != totalSemanas) {
            throw new NegocioException("La suma de las semanas de los mesociclos debe de ser igual al total de semanas del macrociclo");
        }
        
        return this.fachadaDatos.actualizarMacrociclo(macrociclo);
    }

    public Macrociclo obtenerMacrociclo(ObjectId idMacrociclo) throws PersistenciaException {
        if (idMacrociclo == null) {
            throw new NegocioException("Los campos no deben de ser nulos");
        }

        Macrociclo macrociclo = this.fachadaDatos.obtenerMacrociclo(idMacrociclo);

        if (macrociclo == null) {
            throw new NegocioException("Ese macrociclo no existe");
        }
        
        return macrociclo;
    }
    
    public List<Macrociclo> obtenerMacrociclosNoAprobados() {
        try {
            return this.fachadaDatos.obtenerMacrociclosNoAprobados();
        } catch (PersistenciaException pe) {
            throw new NegocioException(pe.getMessage(), pe.getCause());
        }
    }
}
