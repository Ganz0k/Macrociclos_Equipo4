/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.github.lgooddatepicker.tableeditors.DateTableEditor;
import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Mesociclo;
import entidades.Microciclo;
import entidades.VolumenMedioFisico;
import enumeradores.Etapa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import utils.ComboBoxRenderer;

/**
 *
 * @author luisg
 */
public class ControlPlanGrafico {
    
    private final INegocio negocio;
    
    public ControlPlanGrafico() {
        this.negocio = new FachadaNegocio();
    }
    
    public void setTableModel(JTable tabla, Macrociclo macrociclo) {
        int totalColumnas = 7;
        
        for (int i = 0; i < macrociclo.getMediosFisicos().size(); i++) {
            if (macrociclo.getMediosFisicos().get(i).getEtapa().equals(Etapa.GENERAL)) {
                totalColumnas++;
            }
        }
        
        String[] nombreColumnas = new String[totalColumnas];
        Class[] tipos = new Class[totalColumnas];
        boolean[] editables = new boolean[totalColumnas];
        int contadorExtra = 7;
        
        nombreColumnas[0] = "Semana";
        nombreColumnas[1] = "Inicia";
        nombreColumnas[2] = "Termina";
        nombreColumnas[3] = "Tests físicos / Competencias prep";
        nombreColumnas[4] = "Mesociclo";
        nombreColumnas[5] = "Ciclicidad";
        nombreColumnas[6] = "Acentos";
        
        tipos[0] = Integer.class;
        tipos[1] = LocalDate.class;
        tipos[2] = LocalDate.class;
        tipos[3] = Object.class;
        tipos[4] = Integer.class;
        tipos[5] = String.class;
        tipos[6] = String.class;
        
        editables[0] = false;
        editables[1] = true;
        editables[2] = true;
        editables[3] = true;
        editables[4] = false;
        editables[5] = false;
        editables[6] = false;
        
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ninguno");
        comboBox.addItem("Test físico");
        comboBox.addItem("Competencia preparatoria");
        
        for (int i = 0; i < macrociclo.getMediosFisicos().size(); i++) {
            if (macrociclo.getMediosFisicos().get(i).getEtapa().equals(Etapa.GENERAL)) {
                nombreColumnas[contadorExtra] = macrociclo.getMediosFisicos().get(i).getNombre();
                tipos[contadorExtra] = Float.class;
                editables[contadorExtra] = true;
                contadorExtra++;
            }
        }
        
        tabla.setModel(new DefaultTableModel(
            new Object[][] {
                    
            },
            nombreColumnas
        ) {
            Class[] types = tipos;
            boolean[] canEdit = editables;
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        tabla.setDefaultEditor(LocalDate.class, new DateTableEditor());
        tabla.setDefaultRenderer(LocalDate.class, new DateTableEditor());
        tabla.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
        tabla.setDefaultRenderer(Object.class, new ComboBoxRenderer(3));
    }
    
    public void cargarTabla(DefaultTableModel tabla, List<Mesociclo> lista) {
        tabla.setRowCount(0);
        int contadorFilas = 1;
        
        String[] acentos2Micros = {"60%", "40%"};
        String[] acentos3Micros = {"25%", "45%", "30%"};
        String[] acentos4Micros = {"15%", "28%", "35%", "22%"};
        String[] acentos5Micros = {"12%", "20%", "24%", "29%", "17%"};
        String[] acentos6Micros = {"12%", "15%", "17%", "20%", "22%", "14%"};
        
        for (Mesociclo m : lista) {
            for (int i = 0; i < m.getNumSemanas(); i++) {
                String ciclicidad = m.getNumSemanas() - 1 + ".1";
                Object[] fila = new Object[tabla.getColumnCount()];
                fila[0] = contadorFilas;
                fila[3] = "Ninguno";
                fila[4] = m.getNumero();
                fila[5] = ciclicidad;
                
                switch (m.getNumSemanas()) {
                    case 2 -> fila[6] = acentos2Micros[i];
                    case 3 -> fila[6] = acentos3Micros[i];
                    case 4 -> fila[6] = acentos4Micros[i];
                    case 5 -> fila[6] = acentos5Micros[i];
                    case 6 -> fila[6] = acentos6Micros[i];
                }
                
                tabla.addRow(fila);
                contadorFilas++;
            }
        }
    }
    
    public void cargarTablaParaActualizar(DefaultTableModel tabla, Macrociclo macrociclo) {
        tabla.setRowCount(0);
        int contadorFilas = 1;
        
        String[] acentos2Micros = {"60%", "40%"};
        String[] acentos3Micros = {"25%", "45%", "30%"};
        String[] acentos4Micros = {"15%", "28%", "35%", "22%"};
        String[] acentos5Micros = {"12%", "20%", "24%", "29%", "17%"};
        String[] acentos6Micros = {"12%", "15%", "17%", "20%", "22%", "14%"};
        
        for (Mesociclo m : macrociclo.getMesociclos()) {
            for (int i = 0; i < m.getMicrociclos().size(); i++) {
                String ciclicidad = m.getNumSemanas() + ",1";
                Object[] fila = new Object[tabla.getColumnCount()];
                fila[0] = contadorFilas;
                fila[1] = m.getMicrociclos().get(i).getInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                fila[2] = m.getMicrociclos().get(i).getFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                if (m.getMicrociclos().get(i).isTestFisico()) {
                    fila[3] = "Test físico";
                } else if (m.getMicrociclos().get(i).isCompetenciaPreparativa()) {
                    fila[3] = "Competencia preparatoria";
                } else {
                    fila[3] = "Ninguno";
                }
                
                fila[4] = m.getNumero();
                fila[5] = ciclicidad;
                
                switch (m.getNumSemanas()) {
                    case 2 -> fila[6] = acentos2Micros[i];
                    case 3 -> fila[6] = acentos3Micros[i];
                    case 4 -> fila[6] = acentos4Micros[i];
                    case 5 -> fila[6] = acentos5Micros[i];
                    case 6 -> fila[6] = acentos6Micros[i];
                }
                
                for (int n = 7; n < tabla.getColumnCount(); n++) {
                    fila[n] = m.getMicrociclos().get(i).getVolumenesMediosFisicos().get(n - 7).getVolumen();
                }
                
                tabla.addRow(fila);
                contadorFilas++;
            }
        }
    }
    
    public void actualizarMicrociclos(JFrame parent, Macrociclo macrociclo, DefaultTableModel tabla) {
        List<Integer> listaNumerosMesociclos = new LinkedList<>();
        List<Microciclo> listaMicrociclos = new LinkedList<>();
        List<MedioFisico> listaMediosFisicos = macrociclo.getMediosFisicos();
        List<Mesociclo> listaMesociclos = macrociclo.getMesociclos();
        int contadorTestFisico = 0;
        int contadorCompetenciaPreparativa = 0;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            LocalDate fechaInicioTabla = (LocalDate) tabla.getValueAt(i, 1);
            
            if (fechaInicioTabla == null) {
                JOptionPane.showMessageDialog(parent, "La fecha de inicio debe de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (i != 0 && fechaInicioTabla.isBefore((LocalDate) tabla.getValueAt(i - 1, 2))) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden transcurrir al mismo tiempo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            GregorianCalendar fechaInicio = new GregorianCalendar(fechaInicioTabla.getYear(), fechaInicioTabla.getMonthValue() - 1, fechaInicioTabla.getDayOfMonth());
            GregorianCalendar fechaInicioOriginal = new GregorianCalendar();
            fechaInicioOriginal.setTime(macrociclo.getFechaInicio());
            
            if (i == 0 && fechaInicio.getTimeInMillis() < fechaInicioOriginal.getTimeInMillis()) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden empezar antes que el macrociclo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            LocalDate fechaFinTabla = (LocalDate) tabla.getValueAt(i, 2);
            
            if (fechaFinTabla == null) {
                JOptionPane.showMessageDialog(parent, "La fecha de fin debe de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
                return;
            }
            
            if (i != 0 && fechaFinTabla.isBefore((LocalDate) tabla.getValueAt(i - 1, 2))) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden transcurrir al mismo tiempo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            GregorianCalendar fechaFin = new GregorianCalendar(fechaFinTabla.getYear(), fechaFinTabla.getMonthValue() - 1, fechaFinTabla.getDayOfMonth());
            GregorianCalendar fechaFinOriginal = new GregorianCalendar();
            fechaFinOriginal.setTime(macrociclo.getFechaFin());
            
            if (i == tabla.getRowCount() - 1 && fechaFin.getTimeInMillis() < fechaFinOriginal.getTimeInMillis()) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden terminar después que el macrociclo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String testPruebaONada = (String) tabla.getValueAt(i, 3);
            boolean isTestFisico = false;
            boolean isCompetenciaPreparativa = false;
            
            switch (testPruebaONada) {
                case "Test físico" -> {
                    isTestFisico = true;
                    contadorTestFisico++;
                }
                case "Competencia preparatoria" -> {
                    isCompetenciaPreparativa = true;
                    contadorCompetenciaPreparativa++;
                }
            }
            
            listaNumerosMesociclos.add((int) tabla.getValueAt(i, 4));
            String acento = (String) tabla.getValueAt(i, 6);
            
            List<VolumenMedioFisico> listaVMF = new ArrayList<>();
            
            for (int j = 7; j < tabla.getColumnCount(); j++) {
                String nombreColumna = tabla.getColumnName(j);
                Object volumen = tabla.getValueAt(i, j);
                
                if (volumen == null) {
                    JOptionPane.showMessageDialog(parent,"Todos los volumenes deben de tener valor", "Adevertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                for (MedioFisico mF : listaMediosFisicos) {
                    if (nombreColumna.equals(mF.getNombre()) && listaNumerosMesociclos.get(i) - 1 < listaMesociclos.size()) {
                        for (VolumenMedioFisico vMF: listaMesociclos.get(listaNumerosMesociclos.get(i) - 1).getDistribucionVolumen()) {
                            if (vMF.getMedioFisico().equals(mF.getId())) {
                                listaVMF.add(new VolumenMedioFisico(new ObjectId(), vMF.getId(), Float.parseFloat(volumen.toString()), 0));
                                break;
                            }
                        } 
                    }
                }
            }
            
            listaMicrociclos.add(new Microciclo(new ObjectId(), fechaInicio.getTime(), fechaFin.getTime(), acento, listaVMF, isCompetenciaPreparativa, isTestFisico));
        }
        
        if (contadorTestFisico == 0 || contadorCompetenciaPreparativa == 0) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 test físico y 1 competencia preparativa en todo el plan", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        List<Microciclo> microciclosAEnviar = new LinkedList<>();
        int contadorSemanas = 0;
        int contadorMesociclos = 0;
        boolean agregado = false;        
        
        for (int i = 0; i < listaNumerosMesociclos.size(); i++) {
            if (agregado) {
                agregado = false;
            }
            
            microciclosAEnviar.add(listaMicrociclos.get(i));
            
            if (contadorMesociclos == listaMesociclos.size()) {
                break;
            }
            
            if (listaMesociclos.get(contadorMesociclos).getNumSemanas() - 1 == contadorSemanas) {
                ObjectId idMesociclo = null;
                
                for (Mesociclo m : listaMesociclos) {
                    if (m.getNumero() == listaNumerosMesociclos.get(i - 1)) {
                        idMesociclo = m.getId();
                        break;
                    }
                }
                
                try {
                    this.negocio.actualizarMicrociclos(macrociclo.getId(), idMesociclo, microciclosAEnviar);
                    microciclosAEnviar = new LinkedList<>();
                    contadorSemanas = 0;
                    contadorMesociclos++;
                    agregado = true;
                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.negocio.eliminarMicrociclos(macrociclo.getId());
                    
                    return;
                }
            }
            
            if (!agregado) {
                contadorSemanas++;
            }
        }
        
        JOptionPane.showMessageDialog(parent, "Microciclos actualizados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void guardarMacrociclo(JFrame parent, Macrociclo macrociclo, DefaultTableModel tabla) {
        List<Integer> listaNumerosMesociclos = new LinkedList<>();
        List<Microciclo> listaMicrociclos = new LinkedList<>();
        List<MedioFisico> listaMediosFisicos = macrociclo.getMediosFisicos();
        List<Mesociclo> listaMesociclos = macrociclo.getMesociclos();
        int contadorTestFisico = 0;
        int contadorCompetenciaPreparativa = 0;
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            LocalDate fechaInicioTabla = (LocalDate) tabla.getValueAt(i, 1);
            
            if (fechaInicioTabla == null) {
                JOptionPane.showMessageDialog(parent, "La fecha de inicio debe de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if (i != 0 && fechaInicioTabla.isBefore((LocalDate) tabla.getValueAt(i - 1, 2))) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden transcurrir al mismo tiempo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            GregorianCalendar fechaInicio = new GregorianCalendar(fechaInicioTabla.getYear(), fechaInicioTabla.getMonthValue() - 1, fechaInicioTabla.getDayOfMonth());
            GregorianCalendar fechaInicioOriginal = new GregorianCalendar();
            fechaInicioOriginal.setTime(macrociclo.getFechaInicio());
            
            if (i == 0 && fechaInicio.getTimeInMillis() < fechaInicioOriginal.getTimeInMillis()) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden empezar antes que el macrociclo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            LocalDate fechaFinTabla = (LocalDate) tabla.getValueAt(i, 2);
            
            if (fechaFinTabla == null) {
                JOptionPane.showMessageDialog(parent, "La fecha de fin debe de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
                return;
            }
            
            if (i != 0 && fechaFinTabla.isBefore((LocalDate) tabla.getValueAt(i - 1, 2))) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden transcurrir al mismo tiempo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            GregorianCalendar fechaFin = new GregorianCalendar(fechaFinTabla.getYear(), fechaFinTabla.getMonthValue() - 1, fechaFinTabla.getDayOfMonth());
            GregorianCalendar fechaFinOriginal = new GregorianCalendar();
            fechaFinOriginal.setTime(macrociclo.getFechaFin());
            
            if (i == tabla.getRowCount() - 1 && fechaFin.getTimeInMillis() < fechaFinOriginal.getTimeInMillis()) {
                JOptionPane.showMessageDialog(parent, "Los microciclos no pueden terminar después que el macrociclo", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String testPruebaONada = (String) tabla.getValueAt(i, 3);
            boolean isTestFisico = false;
            boolean isCompetenciaPreparativa = false;
            
            switch (testPruebaONada) {
                case "Test físico" -> {
                    isTestFisico = true;
                    contadorTestFisico++;
                }
                case "Competencia preparatoria" -> {
                    isCompetenciaPreparativa = true;
                    contadorCompetenciaPreparativa++;
                }
            }
            
            listaNumerosMesociclos.add((int) tabla.getValueAt(i, 4));
            String acento = (String) tabla.getValueAt(i, 6);
            
            List<VolumenMedioFisico> listaVMF = new ArrayList<>();
            
            for (int j = 7; j < tabla.getColumnCount(); j++) {
                String nombreColumna = tabla.getColumnName(j);
                Object volumen = tabla.getValueAt(i, j);
                
                if (volumen == null) {
                    JOptionPane.showMessageDialog(parent,"Todos los volumenes deben de tener valor", "Adevertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                for (MedioFisico mF : listaMediosFisicos) {
                    if (nombreColumna.equals(mF.getNombre()) && listaNumerosMesociclos.get(i) - 1 < listaMesociclos.size()) {
                        for (VolumenMedioFisico vMF: listaMesociclos.get(listaNumerosMesociclos.get(i) - 1).getDistribucionVolumen()) {
                            if (vMF.getMedioFisico().equals(mF.getId())) {
                                listaVMF.add(new VolumenMedioFisico(new ObjectId(), vMF.getId(), Float.parseFloat(volumen.toString()), 0));
                                break;
                            }
                        } 
                    }
                }
            }
            
            listaMicrociclos.add(new Microciclo(new ObjectId(), fechaInicio.getTime(), fechaFin.getTime(), acento, listaVMF, isCompetenciaPreparativa, isTestFisico));
        }
        
        if (contadorTestFisico == 0 || contadorCompetenciaPreparativa == 0) {
            JOptionPane.showMessageDialog(parent, "Debe de haber por lo menos 1 test físico y 1 competencia preparativa en todo el plan", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        List<Microciclo> microciclosAEnviar = new LinkedList<>();
        int contadorSemanas = 0;
        int contadorMesociclos = 0;
        boolean agregado = false;        
        
        for (int i = 0; i < listaNumerosMesociclos.size(); i++) {
            if (agregado) {
                agregado = false;
            }
            
            microciclosAEnviar.add(listaMicrociclos.get(i));
            
            if (contadorMesociclos == listaMesociclos.size()) {
                break;
            }
            
            if (listaMesociclos.get(contadorMesociclos).getNumSemanas() - 1 == contadorSemanas) {
                ObjectId idMesociclo = null;
                
                for (Mesociclo m : listaMesociclos) {
                    if (m.getNumero() == listaNumerosMesociclos.get(i - 1)) {
                        idMesociclo = m.getId();
                        break;
                    }
                }
                
                try {
                    this.negocio.validarMicrociclos(macrociclo.getId(), idMesociclo, microciclosAEnviar);
                    microciclosAEnviar = new LinkedList<>();
                    contadorSemanas = 0;
                    contadorMesociclos++;
                    agregado = true;
                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.negocio.eliminarMicrociclos(macrociclo.getId());
                    
                    return;
                }
            }
            
            if (!agregado) {
                contadorSemanas++;
            }
        }
        
        try {
            this.negocio.guardarMacrociclo(macrociclo);
            JOptionPane.showMessageDialog(parent, "Macrociclo guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (PersistenciaException | NegocioException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
