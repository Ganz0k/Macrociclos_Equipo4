/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Microciclo;
import entidades.VolumenMedioFisico;
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
 * @author Yorsh
 */
public class MicrocicloController {
    
    private final IDatos fachadaDatos;
    
    public MicrocicloController() {
        this.fachadaDatos = new FachadaDatos();
    }
    
    public boolean guardarMicrociclo(ObjectId idMacrociclo, ObjectId idMesociclo, List<Microciclo> microciclos) throws PersistenciaException {
        if (idMacrociclo == null || idMesociclo == null || microciclos == null) {
            throw new NegocioException("Ninguno de los campos puede ser nulo");
        }
        
        if (microciclos.isEmpty()) {
            throw new NegocioException("No se pueden guardar microciclos si no existen");
        }
        
        for (Microciclo m : microciclos) {
            if (m.getVolumenesMediosFisicos().isEmpty()) {
                throw new NegocioException("Los microciclos no pueden no tener volumen");
            }
            
            for (VolumenMedioFisico vMF : m.getVolumenesMediosFisicos()) {
                if (vMF.getVolumen() < 0) {
                    throw new NegocioException("Los volúmenes no pueden ser negativos");
                }
            }
            
            GregorianCalendar anioActualC = new GregorianCalendar();
            anioActualC.set(GregorianCalendar.MONTH, GregorianCalendar.JANUARY);
            anioActualC.set(GregorianCalendar.DAY_OF_MONTH, 1);
            anioActualC.set(GregorianCalendar.HOUR_OF_DAY, 0);
            anioActualC.set(GregorianCalendar.MINUTE, 0);
            anioActualC.set(GregorianCalendar.SECOND, 0);
            anioActualC.set(GregorianCalendar.MILLISECOND, 0);
            
            Date anioActual = anioActualC.getTime();
            
            if (m.getInicio().before(anioActual) || m.getFin().before(anioActual)) {
                throw new NegocioException("Las fechas no pueden ser de un año menor al actual");
            }
            
            if (m.getFin().getTime() <= m.getInicio().getTime()) {
                throw new NegocioException("La fecha de fin no puede ser menor o igual a la de inicio");
            }
            
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(m.getInicio());
            
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(m.getFin());
            
            int weekdays = 0;
            
            while (cal1.before(cal2) || cal1.equals(cal2)) {
                int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
                
                if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                    weekdays++;
                }
                
                cal1.add(Calendar.DAY_OF_MONTH, 1);
            }
            
            if (weekdays != 5) {
                throw new NegocioException("El periodo de la fecha de inicio y fin debe de ser de 5 días");
            }
        }
        
        return this.fachadaDatos.actualizarMicrociclos(idMacrociclo, idMesociclo, microciclos);
    }
    
    public boolean eliminarMicrociclos(ObjectId idMacrociclo) throws PersistenciaException {
        if (idMacrociclo == null) {
            throw new NegocioException("El id no puede ser nulo");
        }
        
        return this.fachadaDatos.eliminarMicrociclos(idMacrociclo);
    }
}