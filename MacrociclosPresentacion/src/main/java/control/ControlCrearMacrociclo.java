/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.github.lgooddatepicker.components.DatePicker;
import entidades.Macrociclo;
import entidades.Mesociclo;
import enumeradores.Etapa;
import enumeradores.Rama;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class ControlCrearMacrociclo {
    
    private final INegocio fachadaNegocio;
    
    public ControlCrearMacrociclo() {
        this.fachadaNegocio = new FachadaNegocio();
    }
    
    public void cargarComboRamas(JComboBox<Rama> comboBoxRama) {
        comboBoxRama.addItem(Rama.VARONIL);
        comboBoxRama.addItem(Rama.FEMENIL);
        comboBoxRama.addItem(Rama.MIXTO);
    }
    
    public void crearListeners(JFrame parent, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        tablaGeneral.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (row == 0) {
                    int semanas = Integer.parseInt(tablaGeneral.getValueAt(row, column).toString());
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    tablaGeneral.setValueAt(ciclicidad, 1, column);
                }
            }
        });
        
        tablaEspecial.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (row == 0) {
                    int semanas = Integer.parseInt(tablaEspecial.getValueAt(row, column).toString());
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    tablaEspecial.setValueAt(ciclicidad, 1, column);
                }
            }
        });
        
        tablaCompetitiva.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (row == 0) {
                    int semanas = Integer.parseInt(tablaCompetitiva.getValueAt(row, column).toString());
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    tablaCompetitiva.setValueAt(ciclicidad, 1, column);
                }
            }
        });
    }
    
    public void calcularSemanas(JFrame parent, DatePicker pickerInicio, DatePicker pickerFin, JTextField campoTextoTotalSemanas) {
        LocalDate fechaInicioLC = pickerInicio.getDate();
        LocalDate fechaFinLC = pickerFin.getDate();
        
        if (fechaInicioLC == null || fechaFinLC == null) {
            JOptionPane.showMessageDialog(parent, "Las fechas deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Date fechaInicio = new GregorianCalendar(fechaInicioLC.getYear(), fechaInicioLC.getMonthValue() - 1, fechaInicioLC.getDayOfMonth()).getTime();
        Date fechaFin = new GregorianCalendar(fechaFinLC.getYear(), fechaFinLC.getMonthValue() - 1, fechaFinLC.getDayOfMonth()).getTime();
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(fechaInicio);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(fechaFin);
        
        int weekdays = 0;
        
        while (cal1.before(cal2) || cal1.equals(cal2)) {
            int dayOfWeek = cal1.get(Calendar.DAY_OF_WEEK);
            
            if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                weekdays++;
            }
            
            cal1.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        int semanas = weekdays / 5;
        
        campoTextoTotalSemanas.setText(String.valueOf(semanas));
    }
    
    public void guardarMacrociclo(JFrame parent, ObjectId entrenador, JComboBox<String> comboBoxDeportes, JComboBox<Rama> comboBoxRama, JComboBox<String> comboBoxJefeRama,
            JComboBox<String> comboBoxEntrenadorAuxiliar, JComboBox<String> comboBoxMetodologo, JTextField campoTextoStatus,
            JTextField campoTextoTotalSemanas, JTextField campoTextoSemanasPreparatorio,
            JTextField campoTextoSemanasCompetitivo, JTextField campoTextoSemanasGeneral,
            JTextField campoTextoSemanasEspecial, JTextField campoTextoSemanasPrecompetitiva,
            JTextField campoTextoSemanasCompetitivoB, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial,
            DefaultTableModel tablaCompetitiva, Date fechaInicio, Date fechaFin) {
        
        String deporte = (String) comboBoxDeportes.getSelectedItem();
        Rama rama = (Rama) comboBoxRama.getSelectedItem();
        String jefeRama = (String) comboBoxJefeRama.getSelectedItem();
        String entrenadorAuxiliar = (String) comboBoxEntrenadorAuxiliar.getSelectedItem();
        String metodologo = (String) comboBoxMetodologo.getSelectedItem();
        String status = campoTextoStatus.getText();
        String txtTotalSemanas = campoTextoTotalSemanas.getText();
        String txtSemanasPreparatorio = campoTextoSemanasPreparatorio.getText();
        String txtSemanasCompetitivo = campoTextoSemanasCompetitivo.getText();
        String txtSemanasGeneral = campoTextoSemanasGeneral.getText();
        String txtSemanasEspecial = campoTextoSemanasEspecial.getText();
        String txtSemanasPrecompetitiva = campoTextoSemanasPrecompetitiva.getText();
        String txtSemanasCompetitivoB = campoTextoSemanasCompetitivoB.getText();
        
        if (txtTotalSemanas == null || txtSemanasPreparatorio == null || txtSemanasCompetitivo == null ||
                txtSemanasGeneral == null || txtSemanasEspecial == null || txtSemanasPrecompetitiva == null ||
                txtSemanasCompetitivoB == null) {
            JOptionPane.showMessageDialog(parent, "Todos los campos deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int totalSemanas = Integer.parseInt(txtTotalSemanas);
        int semanasPreparatorio = Integer.parseInt(txtSemanasPreparatorio);
        int semanasCompetitivo = Integer.parseInt(txtSemanasCompetitivo);
        int semanasGeneral = Integer.parseInt(txtSemanasGeneral);
        int semanasEspecial = Integer.parseInt(txtSemanasEspecial);
        int semanasPrecompetitiva = Integer.parseInt(txtSemanasPrecompetitiva);
        int semanasCompetitivoB = Integer.parseInt(txtSemanasCompetitivoB);
        
        int totalSemanasB = semanasPreparatorio + semanasCompetitivo;
        int totalSemanasPreparatorio = semanasGeneral + semanasEspecial;
        int totalSemanasCompetitivo = semanasPrecompetitiva + semanasCompetitivoB;
        
        if (totalSemanasB != totalSemanas || totalSemanasPreparatorio != semanasPreparatorio || totalSemanasCompetitivo != semanasCompetitivo) {
            JOptionPane.showMessageDialog(parent, "La suma de porcentajes de los periodos debe ser igual al total de semanas del macrociclo", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        List<Mesociclo> listaMesociclos = new ArrayList<>();
        int contadorMesociclos = 1;
        int contadorNulls = 0;
        
        for (int i = 0; i < tablaGeneral.getColumnCount(); i++) {
            Object semanasMesociclo = tablaGeneral.getValueAt(0, i);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.GENERAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == 10) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaEspecial.getColumnCount(); i++) {
            Object semanasMesociclo = tablaEspecial.getValueAt(0, i);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.ESPECIAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == 10) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaCompetitiva.getColumnCount(); i++) {
            Object semanasMesociclo = tablaCompetitiva.getValueAt(0, i);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.COMPETITIVA, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == 10) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Macrociclo nuevoMacrociclo = new Macrociclo(new ObjectId(), entrenador, status, deporte, rama, jefeRama, entrenadorAuxiliar, metodologo, fechaInicio, fechaFin, semanasGeneral, semanasEspecial, totalSemanasCompetitivo, new ArrayList<>(), listaMesociclos);
        
        try {
            this.fachadaNegocio.guardarMacrociclo(nuevoMacrociclo);
            JOptionPane.showMessageDialog(parent, "Macrociclo creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException | PersistenciaException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}