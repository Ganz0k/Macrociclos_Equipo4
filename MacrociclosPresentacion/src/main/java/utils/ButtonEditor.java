/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisg
 */
public class ButtonEditor extends DefaultCellEditor {
    
    private JButton button;
    private JFrame parent;
    private JTable tabla;
    
    public ButtonEditor(JTextField textField, JFrame parent, JTable tabla) {
        super(textField);
        this.button = new JButton();
        this.parent = parent;
        this.tabla = tabla;
        
        this.button.addActionListener(e -> {
            fireEditingStopped();
            
            int row = this.tabla.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) this.tabla.getModel();
            
            float volumenGeneral = 0f;
            float volumenEspecial = 0f;
            float volumenCompetitivo = 0f;
            Object minGeneral = model.getValueAt(row, 1);
            Object maxGeneral = model.getValueAt(row, 2);
            Object insGeneral = model.getValueAt(row, 4);
            Object semanasGeneral = model.getValueAt(row, 5);
            Object minEspecial = model.getValueAt(row, 7);
            Object maxEspecial = model.getValueAt(row, 8);
            Object insEspecial = model.getValueAt(row, 10);
            Object semanasEspecial = model.getValueAt(row, 11);
            Object minCompetitivo = model.getValueAt(row, 13);
            Object maxCompetitivo = model.getValueAt(row, 14);
            Object insCompetitivo = model.getValueAt(row, 16);
            Object semanasCompetitivo = model.getValueAt(row, 17);
            
            if (minGeneral != null && maxGeneral != null && insGeneral != null && semanasGeneral != null) {
                if (Integer.parseInt(minGeneral.toString()) < 0 || Integer.parseInt(maxGeneral.toString()) < 0 || Integer.parseInt(insGeneral.toString()) < 0 || Integer.parseInt(semanasGeneral.toString()) < 0) {
                    JOptionPane.showMessageDialog(parent, "No se admiten números menores de 0", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                float promedioGeneral = (Integer.parseInt(minGeneral.toString()) + Integer.parseInt(maxGeneral.toString())) / 2f;
                model.setValueAt(promedioGeneral, row, 3);
                
                volumenGeneral = promedioGeneral * Integer.parseInt(insGeneral.toString()) * Integer.parseInt(semanasGeneral.toString());
                model.setValueAt(volumenGeneral, row, 6);
            }
            
            if (minEspecial != null && maxEspecial != null && insEspecial != null && semanasEspecial != null) {
                if (Integer.parseInt(minEspecial.toString()) < 0 || Integer.parseInt(maxEspecial.toString()) < 0 || Integer.parseInt(insEspecial.toString()) < 0 || Integer.parseInt(semanasEspecial.toString()) < 0) {
                    JOptionPane.showMessageDialog(parent, "No se admiten números menores de 0", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                float promedioEspecial = (Integer.parseInt(minEspecial.toString()) + Integer.parseInt(maxEspecial.toString())) / 2f;
                model.setValueAt(promedioEspecial, row, 9);
                
                volumenEspecial = promedioEspecial * Integer.parseInt(insEspecial.toString()) * Integer.parseInt(semanasEspecial.toString());
                model.setValueAt(volumenEspecial, row, 12);
            }
            
            if (minCompetitivo != null && maxCompetitivo != null && insCompetitivo != null && semanasCompetitivo != null) {
                if (Integer.parseInt(minCompetitivo.toString()) < 0 || Integer.parseInt(maxCompetitivo.toString()) < 0 || Integer.parseInt(insCompetitivo.toString()) < 0 || Integer.parseInt(semanasCompetitivo.toString()) < 0) {
                    JOptionPane.showMessageDialog(parent, "No se admiten números menores de 0", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                float promedioCompetitivo = (Integer.parseInt(minCompetitivo.toString()) + Integer.parseInt(maxCompetitivo.toString())) / 2f;
                model.setValueAt(promedioCompetitivo, row, 15);
                
                volumenCompetitivo = promedioCompetitivo * Integer.parseInt(insCompetitivo.toString()) * Integer.parseInt(semanasCompetitivo.toString());
                model.setValueAt(volumenCompetitivo, row, 18);
            }
            
            float volumenTotal = volumenGeneral + volumenEspecial + volumenCompetitivo;
            model.setValueAt(volumenTotal, row, 19);
        });
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "Calcular";
    }
}
