/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.text.SimpleDateFormat;
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
 * @author Yorsh
 */
public class ControlCambiarStatusMacrociclo {
    private final INegocio fachadaNegocio = new FachadaNegocio();
    private JComboBox<String> statusComboBox;
    
    public void llenarTabla(JTable statusMacroTbl){
        DefaultTableModel tableModel = (DefaultTableModel) statusMacroTbl.getModel();
        
        statusComboBox = new JComboBox<>(new String[]{"En tránsito", "Aprobado", "No aprobado"});
        statusMacroTbl.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(statusComboBox));
        statusMacroTbl.setDefaultRenderer(Object.class, new ComboBoxRenderer(4));
        
        tableModel.setRowCount(0);
        List<Macrociclo> macrociclos = fachadaNegocio.obtenerMacrociclosNoAprobados(); 
        
        for (Macrociclo macrociclo : macrociclos) {
            Object[] fila = new Object[5];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaInicio = dateFormat.format(macrociclo.getFechaInicio());
            String fechaFin = dateFormat.format(macrociclo.getFechaFin());
            fila[0] = macrociclo.getId();
            fila[1] = macrociclo.getDeporte();
            fila[2] = fechaInicio;
            fila[3] = fechaFin;
            fila[4] = macrociclo.getStatus();

            tableModel.addRow(fila);
        }
        
        //statusMacroTbl = new JTable(tableModel);
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
                    macrociclo.setStatus(nuevoEstado);
                    fachadaNegocio.actualizarStatus(selectedId, nuevoEstado);
                    JOptionPane.showMessageDialog(parent, "Estado actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(parent, "Selecciona un macrociclo para actualizar el estatus.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
