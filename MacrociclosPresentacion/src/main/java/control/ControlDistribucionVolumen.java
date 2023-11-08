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
        this.negocio.eliminarDistribuciones(macrociclo.getId());
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
                default -> {
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
                default -> {
                }
            }
        });
    }
    
    public void crearListeners(DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        tablaGeneral.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                
                this.recargarTabla(tablaGeneral, row);
            }
        });
        
        tablaEspecial.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                
                this.recargarTabla(tablaEspecial, row);
            }
        });
        
        tablaCompetitiva.addTableModelListener((TableModelEvent e) -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                
                this.recargarTabla(tablaCompetitiva, row);
            }
        });
    }
    
    public void guardarDistribucionesVolumenes(JFrame parent, Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        VolumenMedioFisico[][] listaGeneral = new VolumenMedioFisico[tablaGeneral.getRowCount()][(tablaGeneral.getColumnCount() - 2) /2];
        VolumenMedioFisico[][] listaEspecial = new VolumenMedioFisico[tablaEspecial.getRowCount()][(tablaEspecial.getColumnCount() - 2) /2];
        VolumenMedioFisico[][] listaCompetitiva = new VolumenMedioFisico[tablaCompetitiva.getRowCount()][(tablaCompetitiva.getColumnCount() - 2) /2];
        List<MedioFisico> listaMedioFisico = macrociclo.getMediosFisicos();
        List<Mesociclo> listaMesociclos = macrociclo.getMesociclos();
        
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            int contadorVolumenes = 0;
            VolumenMedioFisico vMF = new VolumenMedioFisico();
            
            for (int j = 0; j < tablaGeneral.getColumnCount(); j++) {
                Object valor = tablaGeneral.getValueAt(i, j);
                
                if (valor == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (j == 0) {
                    for (MedioFisico mF : listaMedioFisico) {
                        if (valor.toString().equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.GENERAL)) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    }
                } else {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        listaGeneral[i][contadorVolumenes] = vMF;
                        vMF = new VolumenMedioFisico(vMF.getMedioFisico());
                        contadorVolumenes++;
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaEspecial.getRowCount(); i++) {
            int contadorVolumenes = 0;
            VolumenMedioFisico vMF = new VolumenMedioFisico();
            
            for (int j = 0; j < tablaEspecial.getColumnCount(); j++) {
                Object valor = tablaEspecial.getValueAt(i, j);
                
                if (valor == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (j == 0) {
                    for (MedioFisico mF: listaMedioFisico) {
                        if (valor.toString().equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.ESPECIAL)) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    }
                } else {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        listaEspecial[i][contadorVolumenes] = vMF;
                        vMF = new VolumenMedioFisico(vMF.getMedioFisico());
                        contadorVolumenes++;
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaCompetitiva.getRowCount(); i++) {
            int contadorVolumenes = 0;
            VolumenMedioFisico vMF = new VolumenMedioFisico();
            
            for (int j = 0; j < tablaCompetitiva.getColumnCount(); j++) {
                Object valor = tablaCompetitiva.getValueAt(i, j);
                
                if (valor == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (j == 0) {
                    for (MedioFisico mF: listaMedioFisico) {
                        if (valor.toString().equals(mF.getNombre()) && mF.getEtapa().equals(Etapa.COMPETITIVA)) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    }
                } else {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        listaCompetitiva[i][contadorVolumenes] = vMF;
                        vMF = new VolumenMedioFisico(vMF.getMedioFisico());
                        contadorVolumenes++;
                    }
                }
            }
        }
        
        for (int i = 0; i < listaGeneral.length; i++) {
            int contadorGeneral = 0;
            int contadorEspecial = 0;
            int contadorCompetitivo = 0;
            
            for (int j = 0; j < listaMesociclos.size(); j++) {
                switch (listaMesociclos.get(j).getEtapa()) {
                    case GENERAL -> {
                        try {
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaGeneral[i][contadorGeneral]);
                            contadorGeneral++;
                        } catch (NegocioException | PersistenciaException e) {
                            this.negocio.eliminarDistribuciones(macrociclo.getId());
                            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            
                            return;
                        }
                    }
                    case ESPECIAL -> {
                        try {
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaEspecial[i][contadorEspecial]);
                            contadorEspecial++;
                        } catch (NegocioException | PersistenciaException e) {
                            this.negocio.eliminarDistribuciones(macrociclo.getId());
                            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        
                            return;
                        }
                    }
                    case COMPETITIVA -> {
                        try {
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaCompetitiva[i][contadorCompetitivo]);
                            contadorCompetitivo++;
                        } catch (NegocioException | PersistenciaException e) {
                            this.negocio.eliminarDistribuciones(macrociclo.getId());
                            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        
                            return;
                        }
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(parent, "Distribución de volúmenes guardada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void recargarTabla(DefaultTableModel tabla, int row) {
        float sumaPorcentaje = 0f;
        int totalColumns = tabla.getColumnCount();
        int totalMesociclos = (totalColumns - 2) / 2;
        Object[] porcentajes = new Object[totalMesociclos];
        Object[] volumenes = new Object[totalMesociclos];
        int contadorExtraPorcentajes = 0;
        int contadorExtraVolumenes = 0;

        for (int i = 3; i < tabla.getColumnCount(); i += 2) {
            Object valor = tabla.getValueAt(row, i);

            if (valor != null) {
                sumaPorcentaje += Float.parseFloat(valor.toString());
                porcentajes[contadorExtraPorcentajes] = Float.parseFloat(valor.toString());
            } else {
                porcentajes[contadorExtraPorcentajes] = null;
            }

            contadorExtraPorcentajes++;
        }

        Object volumenTotalObject = tabla.getValueAt(row, 1);
        float volumenTotal = Float.parseFloat(volumenTotalObject.toString());

        for (int i = 2; i < tabla.getColumnCount(); i += 2) {
            Object porcentaje = tabla.getValueAt(row, i + 1);

            if (porcentaje != null) {
                float volumenMesociclo = volumenTotal / sumaPorcentaje * Float.parseFloat(porcentaje.toString());
                volumenes[contadorExtraVolumenes] = volumenMesociclo;
            } else {
                volumenes[contadorExtraVolumenes] = null;
            }

            contadorExtraVolumenes++;
        }

        Object[] oldFila = new Object[tabla.getColumnCount()];
        contadorExtraPorcentajes = 0;
        contadorExtraVolumenes = 0;

        for (int i = 0; i < oldFila.length; i++) {
            if (i == 0 || i == 1) {
                oldFila[i] = tabla.getValueAt(row, i);
            }

            if (this.isPair(i) && i > 1) {
                oldFila[i] = volumenes[contadorExtraVolumenes];
                contadorExtraVolumenes++;
            }

            if (!this.isPair(i) && i > 1) {
                oldFila[i] = porcentajes[contadorExtraPorcentajes];
                contadorExtraPorcentajes++;
            }
        }

        tabla.removeRow(row);
        tabla.addRow(oldFila);
    }
    
    private boolean isPair(int numero) {
        return numero % 2 == 0;
    }
}
