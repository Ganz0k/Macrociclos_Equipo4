/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import excepciones.NegocioException;
import fachadas.FachadaNegocio;
import guis.CrearMacrociclo;
import guis.SeleccionarMacrocicloEditarFrame;
import interfaces.INegocio;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisg
 */
public class ControlSeleccionarMacrocicloEditar {
    
    private final INegocio fachadaNegocio;
    
    public ControlSeleccionarMacrocicloEditar() {
        this.fachadaNegocio = new FachadaNegocio();
    }
    
    public void cargarTabla(SeleccionarMacrocicloEditarFrame parent, DefaultTableModel tabla) {
        tabla.setRowCount(0);
        
        try {
            List<Macrociclo> lista = this.fachadaNegocio.obtenerMacrociclosNoAprobados();
            
            for (Macrociclo m : lista) {
                Object[] fila = new Object[4];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String fechaInicio = dateFormat.format(m.getFechaInicio());
                String fechaFin = dateFormat.format(m.getFechaFin());
                fila[0] = m.getDeporte();
                fila[1] = fechaInicio;
                fila[2] = fechaFin;
                fila[3] = m.getStatus();

                tabla.addRow(fila);
            }
            
            parent.lista = lista;
        } catch (NegocioException ne) {
            JOptionPane.showMessageDialog(parent, ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mandarActualizar(JFrame parent, JTable tabla, List<Macrociclo> lista) {
        int fila = tabla.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(parent, "Seleccione una fila antes de continuar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        new CrearMacrociclo(lista.get(fila)).setVisible(true);
        parent.dispose();
    }
}
