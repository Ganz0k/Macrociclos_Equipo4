/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import entidades.Mesociclo;
import enumeradores.Etapa;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        int totalColumnas = 8;
        
        for (int i = 0; i < macrociclo.getMediosFisicos().size(); i++) {
            if (macrociclo.getMediosFisicos().get(i).getEtapa().equals(Etapa.GENERAL)) {
                totalColumnas++;
            }
        }
        
        String[] nombreColumnas = new String[totalColumnas];
        Class[] tipos = new Class[totalColumnas];
        boolean[] editables = new boolean[totalColumnas];
        int contadorExtra = 8;
        
        nombreColumnas[0] = "Semana";
        nombreColumnas[1] = "Inicia";
        nombreColumnas[2] = "Termina";
        nombreColumnas[3] = "Tests físicos";
        nombreColumnas[4] = "Mesociclo";
        nombreColumnas[5] = "Ciclicidad";
        nombreColumnas[6] = "Acentos";
        nombreColumnas[7] = "Competencias prep";
        
        tipos[0] = Integer.class;
        tipos[1] = String.class;
        tipos[2] = String.class;
        tipos[3] = Boolean.class;
        tipos[4] = Integer.class;
        tipos[5] = String.class;
        tipos[6] = String.class;
        tipos[7] = Boolean.class;
        
        editables[0] = false;
        editables[1] = true;
        editables[2] = true;
        editables[3] = true;
        editables[4] = false;
        editables[5] = false;
        editables[6] = false;
        editables[7] = true;
        
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
                fila[3] = false;
                fila[4] = m.getNumero();
                fila[5] = ciclicidad;
                
                switch (m.getNumSemanas()) {
                    case 2 -> fila[6] = acentos2Micros[i];
                    case 3 -> fila[6] = acentos3Micros[i];
                    case 4 -> fila[6] = acentos4Micros[i];
                    case 5 -> fila[6] = acentos5Micros[i];
                    case 6 -> fila[6] = acentos6Micros[i];
                }
                
                fila[7] = false;
                tabla.addRow(fila);
                contadorFilas++;
            }
        }
    }
}
