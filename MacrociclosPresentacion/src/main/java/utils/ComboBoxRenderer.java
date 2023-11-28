/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author luisg
 */
public class ComboBoxRenderer extends DefaultTableCellRenderer {
    
    private int col;
    
    public ComboBoxRenderer(int col) {
        this.col = col;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (col == column) {
            JComboBox comboBox = new JComboBox();
            comboBox.addItem(value);
            return comboBox;
        }
        
        return cellComponent;
    }
}
