/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Mesociclo;
import entidades.VolumenMedioFisico;
import enumeradores.Etapa;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class ControlDistribucionVolumen {
    
    private final INegocio negocio;
    
    public ControlDistribucionVolumen() {
        this.negocio = new FachadaNegocio();
    }
    
    public void setTablesModels(Macrociclo macrociclo, JTable tablaGeneral, JTable tablaEspecial, JTable tablaCompetitiva) {
        int columnasGeneral = 2;
        int columnasEspecial = 2;
        int columnasCompetitiva = 2;
        
        for (Mesociclo m : macrociclo.getMesociclos()) {
            switch (m.getEtapa()) {
                case GENERAL -> columnasGeneral += 2;
                case ESPECIAL -> columnasEspecial += 2;
                case COMPETITIVA -> columnasCompetitiva += 2;
            }
        }
        
        String[] nombreColumnasGeneral = new String[columnasGeneral];
        String[] nombreColumnasEspecial = new String[columnasEspecial];
        String[] nombreColumnasCompetitiva = new String[columnasCompetitiva];
        Class[] tiposGeneral = new Class[columnasGeneral];
        Class[] tiposEspecial = new Class[columnasEspecial];
        Class[] tiposCompetitiva = new Class[columnasCompetitiva];
        boolean[] editablesGeneral = new boolean[columnasGeneral];
        boolean[] editablesEspecial = new boolean[columnasEspecial];
        boolean[] editablesCompetitiva = new boolean[columnasCompetitiva];
        int contadorGeneral = 2; 
        int contadorEspecial = 2;
        int contadorCompetitivo = 2;
        
        nombreColumnasGeneral[0] = "Medios físicos";
        nombreColumnasGeneral[1] = "Volumen total";
        tiposGeneral[0] = String.class;
        tiposGeneral[1] = Float.class;
        editablesGeneral[0] = false;
        editablesGeneral[1] = false;
        
        nombreColumnasEspecial[0] = "Medios físicos";
        nombreColumnasEspecial[1] = "Volumen total";
        tiposEspecial[0] = String.class;
        tiposEspecial[1] = Float.class;
        editablesEspecial[0] = false;
        editablesEspecial[1] = false;
        
        nombreColumnasCompetitiva[0] = "Medios físicos";
        nombreColumnasCompetitiva[1] = "Volumen total";
        tiposCompetitiva[0] = String.class;
        tiposCompetitiva[1] = Float.class;
        editablesCompetitiva[0] = false;
        editablesCompetitiva[1] = false;
        
        for (Mesociclo m : macrociclo.getMesociclos()) {
            switch (m.getEtapa()) {
                case GENERAL -> {
                    nombreColumnasGeneral[contadorGeneral] = "Volumen";
                    nombreColumnasGeneral[contadorGeneral + 1] = "%";
                    tiposGeneral[contadorGeneral] = Float.class;
                    tiposGeneral[contadorGeneral + 1] = Float.class;
                    editablesGeneral[contadorGeneral] = false;
                    editablesGeneral[contadorGeneral + 1] = true;
                    contadorGeneral += 2;
                }
                case ESPECIAL -> {
                    nombreColumnasEspecial[contadorEspecial] = "Volumen";
                    nombreColumnasEspecial[contadorEspecial + 1] = "%";
                    tiposEspecial[contadorEspecial] = Float.class;
                    tiposEspecial[contadorEspecial + 1] = Float.class;
                    editablesEspecial[contadorEspecial] = false;
                    editablesEspecial[contadorEspecial + 1] = true;
                    contadorEspecial += 2;
                }
                case COMPETITIVA -> {
                    nombreColumnasCompetitiva[contadorCompetitivo] = "Volumen";
                    nombreColumnasCompetitiva[contadorCompetitivo + 1] = "%";
                    tiposCompetitiva[contadorCompetitivo] = Float.class;
                    tiposCompetitiva[contadorCompetitivo + 1] = Float.class;
                    editablesCompetitiva[contadorCompetitivo] = false;
                    editablesCompetitiva[contadorCompetitivo + 1] = true;
                    contadorCompetitivo += 2;
                }
            }
        }
        
        tablaGeneral.setModel(new DefaultTableModel(
            new Object[][] {
                
            },
            nombreColumnasGeneral
        ) {
            Class[] types = tiposGeneral;
            boolean[] canEdit = editablesGeneral;
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        tablaEspecial.setModel(new DefaultTableModel(
            new Object[][] {
                
            },
            nombreColumnasEspecial
        ) {
            Class[] types = tiposEspecial;
            boolean[] canEdit = editablesEspecial;
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        tablaCompetitiva.setModel(new DefaultTableModel(
            new Object[][] {
                
            },
            nombreColumnasCompetitiva
        ) {
            Class[] types = tiposCompetitiva;
            boolean[] canEdit = editablesCompetitiva;
            
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    public void cargarTablas(Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        List<MedioFisico> lista = macrociclo.getMediosFisicos();
        List<Mesociclo> listaM = macrociclo.getMesociclos();
        
        tablaGeneral.setColumnCount(0);
        tablaGeneral.setRowCount(0);
        tablaEspecial.setColumnCount(0);
        tablaEspecial.setRowCount(0);
        tablaCompetitiva.setColumnCount(0);
        tablaCompetitiva.setRowCount(0);
        
        tablaGeneral.addColumn("Medios físicos");
        tablaGeneral.addColumn("Volumen total");
        tablaEspecial.addColumn("Medios físicos");
        tablaEspecial.addColumn("Volumen total");
        tablaCompetitiva.addColumn("Medios físicos");
        tablaCompetitiva.addColumn("Volumen total");
        
        listaM.forEach(m -> {
            switch (m.getEtapa()) {
                case GENERAL -> {
                    tablaGeneral.addColumn("Vol");
                    tablaGeneral.addColumn("%");
                }
                case ESPECIAL -> {
                    tablaEspecial.addColumn("Vol");
                    tablaEspecial.addColumn("%");
                }
                case COMPETITIVA -> {
                    tablaCompetitiva.addColumn("Vol");
                    tablaCompetitiva.addColumn("%");
                }
            }
        });
        
        lista.forEach(mF -> {
            switch (mF.getEtapa()) {
                case GENERAL -> {
                    Object[] fila = new Object[tablaGeneral.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    tablaGeneral.addRow(fila);
                }
                case ESPECIAL -> {
                    Object[] fila = new Object[tablaEspecial.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    tablaEspecial.addRow(fila);
                }
                case COMPETITIVA -> {
                    Object[] fila = new Object[tablaCompetitiva.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    tablaCompetitiva.addRow(fila);
                }
            }
        });
    }
    
    public void cargarTablasParaActualizar(Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        List<MedioFisico> lista = macrociclo.getMediosFisicos();
        List<Mesociclo> listaM = macrociclo.getMesociclos();
        List<Mesociclo> listaMGeneral = new ArrayList<>();
        List<Mesociclo> listaMEspecial = new ArrayList<>();
        List<Mesociclo> listaMCompetitiva = new ArrayList<>();
        
        tablaGeneral.setColumnCount(0);
        tablaGeneral.setRowCount(0);
        tablaEspecial.setColumnCount(0);
        tablaEspecial.setRowCount(0);
        tablaCompetitiva.setColumnCount(0);
        tablaCompetitiva.setRowCount(0);
        
        tablaGeneral.addColumn("Medios físicos");
        tablaGeneral.addColumn("Volumen total");
        tablaEspecial.addColumn("Medios físicos");
        tablaEspecial.addColumn("Volumen total");
        tablaCompetitiva.addColumn("Medios físicos");
        tablaCompetitiva.addColumn("Volumen total");
        
        for (Mesociclo m: listaM) {
            switch (m.getEtapa()) {
                case GENERAL -> {
                    tablaGeneral.addColumn("Vol");
                    tablaGeneral.addColumn("%");
                    listaMGeneral.add(m);
                }
                case ESPECIAL -> {
                    tablaEspecial.addColumn("Vol");
                    tablaEspecial.addColumn("%");
                    listaMEspecial.add(m);
                }
                case COMPETITIVA -> {
                    tablaCompetitiva.addColumn("Vol");
                    tablaCompetitiva.addColumn("%");
                    listaMCompetitiva.add(m);
                }
            }
        }
        
        VolumenMedioFisico[][] volumenesGeneral = new VolumenMedioFisico[lista.size() / 3][listaMGeneral.size()];
        VolumenMedioFisico[][] volumenesEspecial = new VolumenMedioFisico[lista.size() / 3][listaMEspecial.size()];
        VolumenMedioFisico[][] volumenesCompetitivo = new VolumenMedioFisico[lista.size() / 3][listaMCompetitiva.size()];
        
        for (int i = 0; i < volumenesGeneral.length; i++) {
            for (int j = 0; j < volumenesGeneral[i].length; j++) {
                volumenesGeneral[i][j] = listaMGeneral.get(j).getDistribucionVolumen().get(i);
            }
        }
        
        for (int i = 0; i < volumenesEspecial.length; i++) {
            for (int j = 0; j < volumenesEspecial[i].length; j++) {
                volumenesEspecial[i][j] = listaMEspecial.get(j).getDistribucionVolumen().get(i);
            }
        }
        
        for (int i = 0; i < volumenesCompetitivo.length; i++) {
            for (int j = 0; j < volumenesCompetitivo[i].length; j++) {
                volumenesCompetitivo[i][j] = listaMCompetitiva.get(j).getDistribucionVolumen().get(i);
            }
        }
        
        int iG = 0;
        int iE = 0;
        int iC = 0;
        
        for (MedioFisico mF : lista) {
            switch (mF.getEtapa()) {
                case GENERAL -> {
                    Object[] fila = new Object[tablaGeneral.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    int iF = 2;
                    
                    for (int j = 0; j < volumenesGeneral[iG].length; j++) {
                        fila[iF] = volumenesGeneral[iG][j].getVolumen();
                        fila[iF + 1] = volumenesGeneral[iG][j].getPorcentaje();
                        iF += 2;
                    }
                    
                    iG++;
                    tablaGeneral.addRow(fila);
                }
                case ESPECIAL -> {
                    Object[] fila = new Object[tablaEspecial.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    int iF = 2;
                    
                    for (int j = 0; j < volumenesEspecial[iE].length; j++) {
                        fila[iF] = volumenesEspecial[iE][j].getVolumen();
                        fila[iF + 1] = volumenesEspecial[iE][j].getPorcentaje();
                        iF += 2;
                    }
                    
                    iE++;
                    tablaEspecial.addRow(fila);
                }
                case COMPETITIVA -> {
                    Object[] fila = new Object[tablaCompetitiva.getColumnCount()];
                    fila[0] = mF.getNombre();
                    fila[1] = mF.getVolumen();
                    int iF = 2;
                    
                    for (int j = 0; j < volumenesCompetitivo[iC].length; j++) {
                        fila[iF] = volumenesCompetitivo[iC][j].getVolumen();
                        fila[iF + 1] = volumenesCompetitivo[iC][j].getPorcentaje();
                        iF += 2;
                    }
                    
                    iC++;
                    tablaCompetitiva.addRow(fila);
                }
            }
        }
    }
    
    public void crearListeners(DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        tablaGeneral.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (!isPair(column)) {
                    this.recargarTabla(tablaGeneral, row);
                }
            }
        });
        
        tablaEspecial.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (!isPair(column)) {
                    this.recargarTabla(tablaEspecial, row);
                }
            }
        });
        
        tablaCompetitiva.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                
                if (!isPair(column)) {
                    this.recargarTabla(tablaCompetitiva, row);
                }
            }
        });
    }
    
    public void actualizarDistribucionesVolumenes(JFrame parent, Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        List<MedioFisico> listaMedioFisico = macrociclo.getMediosFisicos();
        int contadorMesos = 0;
        
        for (int i = 2; i < tablaGeneral.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaGeneral.getRowCount(); j++) {
                String nombre = (String) tablaGeneral.getValueAt(j, 0);
                Object volumen = tablaGeneral.getValueAt(j, i);
                Object porcentaje = tablaGeneral.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.GENERAL)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                try {
                    this.negocio.actualizarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString())));
                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.negocio.eliminarDistribuciones(macrociclo.getId());
                    
                    return;
                }
            }
            
            contadorMesos++;
        }
        
        for (int i = 2; i < tablaEspecial.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaEspecial.getRowCount(); j++) {
                String nombre = (String) tablaEspecial.getValueAt(j, 0);
                Object volumen = tablaEspecial.getValueAt(j, i);
                Object porcentaje = tablaEspecial.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.ESPECIAL)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                try {
                    this.negocio.actualizarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString())));
                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.negocio.eliminarDistribuciones(macrociclo.getId());
                    
                    return;
                }
            }
            
            contadorMesos++;
        }
        
        for (int i = 2; i < tablaCompetitiva.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaCompetitiva.getRowCount(); j++) {
                String nombre = (String) tablaCompetitiva.getValueAt(j, 0);
                Object volumen = tablaCompetitiva.getValueAt(j, i);
                Object porcentaje = tablaCompetitiva.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.COMPETITIVA)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                try {
                    this.negocio.actualizarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString())));
                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    this.negocio.eliminarDistribuciones(macrociclo.getId());
                    
                    return;
                }
            }
            
            contadorMesos++;
        }
        
        JOptionPane.showMessageDialog(parent, "Distribución de volúmenes guardada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//        new PlanGraficoFrame().setVisible(true);
//        parent.dispose();
    }
    
    public void guardarDistribucionesDeVolumenes(JFrame parent, Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        List<MedioFisico> listaMedioFisico = macrociclo.getMediosFisicos();
        int contadorMesos = 0;
        
        for (int i = 2; i < tablaGeneral.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaGeneral.getRowCount(); j++) {
                String nombre = (String) tablaGeneral.getValueAt(j, 0);
                Object volumen = tablaGeneral.getValueAt(j, i);
                Object porcentaje = tablaGeneral.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.GENERAL)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                VolumenMedioFisico nuevoVolumen = new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString()));
                
                try {
                    this.negocio.validarVolumenMedioFisico(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), nuevoVolumen);
                } catch (NegocioException ne) {
                    JOptionPane.showMessageDialog(parent, ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                macrociclo.getMesociclos().get(contadorMesos).getDistribucionVolumen().add(nuevoVolumen);
            }
            
            contadorMesos++;
        }
        
        for (int i = 2; i < tablaEspecial.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaEspecial.getRowCount(); j++) {
                String nombre = (String) tablaEspecial.getValueAt(j, 0);
                Object volumen = tablaEspecial.getValueAt(j, i);
                Object porcentaje = tablaEspecial.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.ESPECIAL)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                VolumenMedioFisico nuevoVolumen = new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString()));
                
                try {
                    this.negocio.validarVolumenMedioFisico(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), nuevoVolumen);
                } catch (NegocioException ne) {
                    JOptionPane.showMessageDialog(parent, ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                macrociclo.getMesociclos().get(contadorMesos).getDistribucionVolumen().add(nuevoVolumen);
            }
            
            contadorMesos++;
        }
        
        for (int i = 2; i < tablaCompetitiva.getColumnCount(); i += 2) {
            for (int j = 0; j < tablaCompetitiva.getRowCount(); j++) {
                String nombre = (String) tablaCompetitiva.getValueAt(j, 0);
                Object volumen = tablaCompetitiva.getValueAt(j, i);
                Object porcentaje = tablaCompetitiva.getValueAt(j, i + 1);
                ObjectId idMedioFisico = null;
                
                if (volumen == null || porcentaje == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                for (MedioFisico mF : listaMedioFisico) {
                    if (nombre.equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.COMPETITIVA)) {
                        idMedioFisico = mF.getId();
                        break;
                    }
                }
                
                VolumenMedioFisico nuevoVolumen = new VolumenMedioFisico(new ObjectId(), idMedioFisico, Float.parseFloat(volumen.toString()), Float.parseFloat(porcentaje.toString()));
                
                try {
                    this.negocio.validarVolumenMedioFisico(macrociclo.getId(), macrociclo.getMesociclos().get(contadorMesos).getId(), nuevoVolumen);
                } catch (NegocioException ne) {
                    JOptionPane.showMessageDialog(parent, ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                macrociclo.getMesociclos().get(contadorMesos).getDistribucionVolumen().add(nuevoVolumen);
            }
            
            contadorMesos++;
        }
    }
    
    private void recargarTabla(DefaultTableModel tabla, int row) {
        float sumaPorcentaje = 0f;

        for (int i = 3; i < tabla.getColumnCount(); i += 2) {
            Object valor = tabla.getValueAt(row, i);

            if (valor != null) {
                sumaPorcentaje += Float.parseFloat(valor.toString());
            }
        }

        Object volumenTotalObject = tabla.getValueAt(row, 1);
        float volumenTotal = Float.parseFloat(volumenTotalObject.toString());

        for (int i = 2; i < tabla.getColumnCount(); i += 2) {
            Object porcentaje = tabla.getValueAt(row, i + 1);

            if (porcentaje != null) {
                float volumenMesociclo = volumenTotal / sumaPorcentaje * Float.parseFloat(porcentaje.toString());
                tabla.setValueAt(volumenMesociclo, row, i);
            }
        }
    }
    
    private boolean isPair(int numero) {
        return numero % 2 == 0;
    }
}
