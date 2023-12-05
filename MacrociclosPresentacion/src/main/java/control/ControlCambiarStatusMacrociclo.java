/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import fachadas.FachadaNegocio;
import guis.CambiarStatusMacrociclo;
import interfaces.INegocio;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.bson.types.ObjectId;

/**
 *
 * @author Yorsh
 */
public class ControlCambiarStatusMacrociclo {
    private final INegocio fachadaNegocio = new FachadaNegocio();
    private JComboBox<String> statusComboBox;
    
    public void llenarTabla(JTable statusMacroTbl){
        DefaultTableModel tableModel = new DefaultTableModel();
        List<Macrociclo> macrociclos = fachadaNegocio.obtenerMacrociclosNoAprobados(); 
        for(Macrociclo macrociclo : macrociclos){
            Object[] fila = new Object[4];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = dateFormat.format(macrociclo.getFechaInicio());
            String fechaFin = dateFormat.format(macrociclo.getFechaFin());
            fila[0] = macrociclo.getId();
            fila[1] = macrociclo.getDeporte();
            fila[2] = fechaInicio;
            fila[3] = fechaFin;

               tableModel.addRow(fila);
        }
        
        statusMacroTbl = new JTable(tableModel);
        statusMacroTbl.getColumnModel().getColumn(4).setCellRenderer(new ControlCambiarStatusMacrociclo.ComboBoxRenderer());
        statusMacroTbl.getColumnModel().getColumn(4).setCellEditor(new ControlCambiarStatusMacrociclo.ComboBoxEditor());
        statusComboBox = new JComboBox<>(new String[]{"En tránsito", "Aprobado"});
       
    }
    
    public void actualizarEstatus(JFrame parent, JTable statusMacroTbl) {
        int selectedRow = statusMacroTbl.getSelectedRow();

        if (selectedRow != -1) {
            // Obtener el ID del macrociclo seleccionado
            ObjectId selectedId = (ObjectId) statusMacroTbl.getValueAt(selectedRow, 0);

            // Obtener el nuevo estado seleccionado
            String nuevoEstado = (String) statusMacroTbl.getValueAt(selectedRow, 4);
            
            List<Macrociclo> macrociclos = fachadaNegocio.obtenerMacrociclosNoAprobados(); 
            // Actualizar el estado en la lista de macrociclos
            for (Macrociclo macrociclo : macrociclos) {
                if (macrociclo.getId().equals(selectedId)) {
                    if(nuevoEstado.equals("Aprobado")){
                        macrociclo.setStatus(nuevoEstado);
                        fachadaNegocio.actualizarMacrociclo(macrociclo);
                        break;      
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(parent, "Selecciona un macrociclo para actualizar el estatus.");
        }
    }
    
    private class ComboBoxRenderer extends DefaultTableCellRenderer {
        private JComboBox<String> comboBox;

        public ComboBoxRenderer() {
            comboBox = new JComboBox<>(new String[]{"En tránsito", "Aprobado"});
            comboBox.setEditable(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            comboBox.setSelectedItem(value);
            return comboBox;
        }
    }
    
    private class ComboBoxEditor extends AbstractCellEditor implements TableCellEditor {
        private JComboBox<String> comboBox;

        public ComboBoxEditor() {
            comboBox = new JComboBox<>(new String[]{"En tránsito", "Otro estado"});
            comboBox.setEditable(true);
            comboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopCellEditing();
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return comboBox.getSelectedItem();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            comboBox.setSelectedItem(value);
            return comboBox;
        }
    }
}
