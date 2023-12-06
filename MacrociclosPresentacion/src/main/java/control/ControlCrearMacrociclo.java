/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.github.lgooddatepicker.components.DatePicker;
import entidades.Macrociclo;
import entidades.Mesociclo;
import enumeradores.Etapa;
import enumeradores.Operacion;
import enumeradores.Rama;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import guis.CalculadoraVolumenFrame;
import interfaces.INegocio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    
    public ControlCrearMacrociclo(INegocio fachadaNegocio) {
        this.fachadaNegocio = fachadaNegocio;
    }
    
    public void cargarComboRamas(JComboBox<Rama> comboBoxRama) {
        comboBoxRama.addItem(Rama.VARONIL);
        comboBoxRama.addItem(Rama.FEMENIL);
        comboBoxRama.addItem(Rama.MIXTO);
    }
    
    public void agregarFilaTabla(DefaultTableModel tabla) {
        tabla.addRow(new Object[2]);
    }
    
    public void eliminarFilaTabla(JFrame parent, JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();
        
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(parent, "Seleccione una fila de la tabla antes de eliminarla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(filaSeleccionada);
    }
    
    public void crearListeners(JFrame parent, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        tablaGeneral.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (column == 0) {
                    int semanas = Integer.parseInt(tablaGeneral.getValueAt(row, column).toString());
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    tablaGeneral.setValueAt(ciclicidad, row, 1);
                }
            }
        });
        
        tablaEspecial.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (column == 0) {
                    int semanas = Integer.parseInt(tablaEspecial.getValueAt(row, column).toString());
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    tablaEspecial.setValueAt(ciclicidad, row, 1);
                }
            }
        });
        
        tablaCompetitiva.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (column == 0) {
                    int semanas = Integer.parseInt(tablaCompetitiva.getValueAt(row, column).toString());
                    String ciclicidad = (semanas - 1) + ",1";
                    
                    if (semanas > 6 || semanas < 2) {
                        JOptionPane.showMessageDialog(parent, "Un mesociclo solo puede tener de 2 a 6 semanas", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    tablaCompetitiva.setValueAt(ciclicidad, row, 1);
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
        
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            Object semanasMesociclo = tablaGeneral.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.GENERAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaGeneral.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaEspecial.getRowCount(); i++) {
            Object semanasMesociclo = tablaEspecial.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.ESPECIAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaEspecial.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaCompetitiva.getRowCount(); i++) {
            Object semanasMesociclo = tablaCompetitiva.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.COMPETITIVA, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaCompetitiva.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Macrociclo nuevoMacrociclo = new Macrociclo(new ObjectId(), entrenador, status, deporte, rama, jefeRama, entrenadorAuxiliar, metodologo, fechaInicio, fechaFin, semanasGeneral, semanasEspecial, semanasPrecompetitiva, semanasCompetitivoB, new ArrayList<>(), listaMesociclos);
        
        new CalculadoraVolumenFrame(nuevoMacrociclo, Operacion.CREAR).setVisible(true);
        parent.dispose();
    }
    
    public void cargarElementosActualizar(Macrociclo macrociclo, JComboBox comboBoxDeporte, JComboBox comboBoxRama, JComboBox comboBoxJefeRama,
            JComboBox comboBoxAuxiliar, JComboBox comboBoxMetodologo, JTextField campoStatus, DatePicker pickerInicio, DatePicker pickerFin,
            JTextField campoTotalSemanas, JTextField campoPorcentajePreparatorio, JTextField campoSemanasPreparatorio, JTextField campoPorcentajeCompetitivo,
            JTextField campoSemanasCompetitivo, JTextField campoPorcentajeGeneral, JTextField campoSemanasGeneral, JTextField campoPorcentajeEspecial,
            JTextField campoSemanasEspecial, JTextField campoPorcentajePrecompetitivo, JTextField campoSemanasPrecompetitivo,
            JTextField campoPorcentajeCompetitivoB, JTextField campoSemanasCompetitivoB, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial,
            DefaultTableModel tablaCompetitiva) {
        comboBoxDeporte.setSelectedItem(macrociclo.getDeporte());
        comboBoxRama.setSelectedItem(macrociclo.getRama());
        comboBoxJefeRama.setSelectedItem(macrociclo.getJefeRama());
        comboBoxAuxiliar.setSelectedItem(macrociclo.getEntrenadorAuxiliar());
        comboBoxMetodologo.setSelectedItem(macrociclo.getMetodologo());
        
        campoStatus.setText(macrociclo.getStatus());
        
        pickerInicio.setDate(macrociclo.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        pickerFin.setDate(macrociclo.getFechaFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        
        Integer totalSemanas = macrociclo.getSemanasGeneral() + macrociclo.getSemanasEspecial() + macrociclo.getSemanasCompetitivo() + macrociclo.getSemanasPrecompetitivo();
        campoTotalSemanas.setText(totalSemanas.toString());
        
        int porcentajePreparatorio = ((macrociclo.getSemanasEspecial() + macrociclo.getSemanasGeneral()) * 100) / totalSemanas;
        campoPorcentajePreparatorio.setText(porcentajePreparatorio + "%");
        
        Integer semanasPreparatorio = macrociclo.getSemanasEspecial() + macrociclo.getSemanasGeneral();
        campoSemanasPreparatorio.setText(semanasPreparatorio.toString());
        
        int porcentajeCompetitivo = ((macrociclo.getSemanasCompetitivo() + macrociclo.getSemanasPrecompetitivo()) * 100) / totalSemanas;
        campoPorcentajeCompetitivo.setText(porcentajeCompetitivo + "%");
        
        Integer semanasCompetitivo = macrociclo.getSemanasCompetitivo();
        campoSemanasCompetitivo.setText(semanasCompetitivo.toString());
        
        int porcentajeGeneral = (macrociclo.getSemanasGeneral() * 100) / totalSemanas;
        campoPorcentajeGeneral.setText(porcentajeGeneral + "%");
        
        Integer semanasGeneral = macrociclo.getSemanasGeneral();
        campoSemanasGeneral.setText(semanasGeneral.toString());
        
        int porcentajeEspecial = (macrociclo.getSemanasEspecial() * 100) / totalSemanas;
        campoPorcentajeEspecial.setText(porcentajeEspecial + "%");
        
        Integer semanasEspecial = macrociclo.getSemanasEspecial();
        campoSemanasEspecial.setText(semanasEspecial.toString());
        
        int porcentajePrecompetitivo = (macrociclo.getSemanasPrecompetitivo() * 100) / totalSemanas;
        campoPorcentajePrecompetitivo.setText(porcentajePrecompetitivo + "%");
        
        Integer semanasPrecompetitivo = macrociclo.getSemanasPrecompetitivo();
        campoSemanasPrecompetitivo.setText(semanasPrecompetitivo.toString());
        
        int porcentajeCompetitivoB = (macrociclo.getSemanasCompetitivo() * 100) / totalSemanas;
        campoPorcentajeCompetitivoB.setText(porcentajeCompetitivoB + "%");
        
        Integer semanasCompetitivoB = macrociclo.getSemanasCompetitivo();
        campoSemanasCompetitivoB.setText(semanasCompetitivoB.toString());
        
        tablaGeneral.setRowCount(0);
        tablaEspecial.setRowCount(0);
        tablaCompetitiva.setRowCount(0);
        
        macrociclo.getMesociclos().forEach(m -> {
            Object[] fila = new Object[2];
            fila[0] = m.getNumSemanas();
            fila[1] = (m.getNumSemanas() - 1) + "." + 1;
            
            switch (m.getEtapa()) {
                case GENERAL -> tablaGeneral.addRow(fila);
                case ESPECIAL -> tablaEspecial.addRow(fila);
                case COMPETITIVA -> tablaCompetitiva.addRow(fila);
            }
        });
    }
    
    public void actualizarMacrociclo(JFrame parent, JComboBox<String> comboBoxDeportes, JComboBox<Rama> comboBoxRama, JComboBox<String> comboBoxJefeRama,
            JComboBox<String> comboBoxEntrenadorAuxiliar, JComboBox<String> comboBoxMetodologo, JTextField campoTextoStatus,
            JTextField campoTextoTotalSemanas, JTextField campoTextoSemanasPreparatorio,
            JTextField campoTextoSemanasCompetitivo, JTextField campoTextoSemanasGeneral,
            JTextField campoTextoSemanasEspecial, JTextField campoTextoSemanasPrecompetitiva,
            JTextField campoTextoSemanasCompetitivoB, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial,
            DefaultTableModel tablaCompetitiva, Date fechaInicio, Date fechaFin, Macrociclo macrociclo) {
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
        
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            Object semanasMesociclo = tablaGeneral.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.GENERAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaGeneral.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaEspecial.getRowCount(); i++) {
            Object semanasMesociclo = tablaEspecial.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.ESPECIAL, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaEspecial.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        contadorNulls = 0;
        
        for (int i = 0; i < tablaCompetitiva.getRowCount(); i++) {
            Object semanasMesociclo = tablaCompetitiva.getValueAt(i, 0);
            
            if (semanasMesociclo == null) {
                contadorNulls++;
                continue;
            }
            
            int numSemanas = Integer.parseInt(semanasMesociclo.toString());
            listaMesociclos.add(new Mesociclo(new ObjectId(), contadorMesociclos, Etapa.COMPETITIVA, numSemanas, new ArrayList<>(), new ArrayList<>()));
            contadorMesociclos++;
        }
        
        if (contadorNulls == tablaCompetitiva.getRowCount()) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 mesociclo definido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        macrociclo.setStatus(status);
        macrociclo.setDeporte(deporte);
        macrociclo.setRama(rama);
        macrociclo.setJefeRama(jefeRama);
        macrociclo.setEntrenadorAuxiliar(entrenadorAuxiliar);
        macrociclo.setMetodologo(metodologo);
        macrociclo.setFechaInicio(fechaInicio);
        macrociclo.setFechaFin(fechaFin);
        macrociclo.setSemanasGeneral(semanasGeneral);
        macrociclo.setSemanasEspecial(semanasEspecial);
        macrociclo.setSemanasPrecompetitivo(semanasPrecompetitiva);
        macrociclo.setSemanasCompetitivo(semanasCompetitivoB);
        macrociclo.setMesociclos(listaMesociclos);
        
        try {
            this.fachadaNegocio.actualizarMacrociclo(macrociclo);
            JOptionPane.showMessageDialog(parent, "Macrociclo actualizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            new CalculadoraVolumenFrame(this.fachadaNegocio.obtenerMacrociclo(macrociclo.getId()), Operacion.CREAR).setVisible(true);
            parent.dispose();
        } catch (NegocioException | PersistenciaException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setNoEditable(JComboBox comboBoxDeporte, JComboBox comboBoxRama, JComboBox comboBoxJefeRama,
            JComboBox comboBoxAuxiliar, JComboBox comboBoxMetodologo, JTextField campoStatus, DatePicker pickerInicio, DatePicker pickerFin,
            JTextField campoTotalSemanas, JTextField campoPorcentajePreparatorio, JTextField campoSemanasPreparatorio, JTextField campoPorcentajeCompetitivo,
            JTextField campoSemanasCompetitivo, JTextField campoPorcentajeGeneral, JTextField campoSemanasGeneral, JTextField campoPorcentajeEspecial,
            JTextField campoSemanasEspecial, JTextField campoPorcentajePrecompetitivo, JTextField campoSemanasPrecompetitivo,
            JTextField campoPorcentajeCompetitivoB, JTextField campoSemanasCompetitivoB, JTable tablaGeneral, JTable tablaEspecial, JTable tablaCompetitiva) {
        comboBoxDeporte.setEditable(false);
        comboBoxRama.setEditable(false);
        comboBoxJefeRama.setEditable(false);
        comboBoxAuxiliar.setEditable(false);
        comboBoxMetodologo.setEditable(false);
        campoStatus.setEditable(false);
        pickerInicio.setEnabled(false);
        pickerFin.setEnabled(false);
        campoTotalSemanas.setEditable(false);
        campoPorcentajePreparatorio.setEditable(false);
        campoSemanasPreparatorio.setEditable(false);
        campoPorcentajeCompetitivo.setEditable(false);
        campoSemanasCompetitivo.setEditable(false);
        campoPorcentajeGeneral.setEditable(false);
        campoSemanasGeneral.setEditable(false);
        campoPorcentajeEspecial.setEditable(false);
        campoSemanasEspecial.setEditable(false);
        campoPorcentajePrecompetitivo.setEditable(false);
        campoSemanasPrecompetitivo.setEditable(false);
        campoPorcentajeCompetitivoB.setEditable(false);
        campoSemanasCompetitivoB.setEditable(false);
        tablaGeneral.setEnabled(false);
        tablaEspecial.setEnabled(false);
        tablaCompetitiva.setEnabled(false);
    }
}
