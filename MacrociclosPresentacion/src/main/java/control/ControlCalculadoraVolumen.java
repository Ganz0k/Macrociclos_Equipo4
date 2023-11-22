/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.MedioFisico;
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
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class ControlCalculadoraVolumen {
    
    private INegocio fachadaNegocio;
    
    public ControlCalculadoraVolumen() {
        this.fachadaNegocio = new FachadaNegocio();
    }
    
    public void anadirNuevaFila(DefaultTableModel tabla) {
        Object[] fila = new Object[21];
        tabla.addRow(fila);
    }
    
    public void eliminarFila(JFrame parent, JTable tabla) {
        int fila = tabla.getSelectedRow();
        
        if (fila == -1) {
            JOptionPane.showMessageDialog(parent, "Seleccione una fila para poder borrar el medio físico", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.removeRow(fila);
    }
    
    public void guardarMediosFisicos(JFrame parent, ObjectId idMacrociclo, DefaultTableModel tabla) {
        List<MedioFisico> lista = new ArrayList<>();
        
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object nombre = tabla.getValueAt(i, 0);
            Object minGeneral = tabla.getValueAt(i, 1);
            Object maxGeneral = tabla.getValueAt(i, 2);
            Object promedioGeneral = tabla.getValueAt(i, 3);
            Object insGeneral = tabla.getValueAt(i, 4);
            Object semanasGeneral = tabla.getValueAt(i, 5);
            Object volumenGeneral = tabla.getValueAt(i, 6);
            Object minEspecial = tabla.getValueAt(i, 7);
            Object maxEspecial = tabla.getValueAt(i, 8);
            Object promedioEspecial = tabla.getValueAt(i, 9);
            Object insEspecial = tabla.getValueAt(i, 10);
            Object semanasEspecial = tabla.getValueAt(i, 11);
            Object volumenEspecial = tabla.getValueAt(i, 12);
            Object minCompetitivo = tabla.getValueAt(i, 13);
            Object maxCompetitivo = tabla.getValueAt(i, 14);
            Object promedioCompetitivo = tabla.getValueAt(i, 15);
            Object insCompetitivo = tabla.getValueAt(i, 16);
            Object semanasCompetitivo = tabla.getValueAt(i, 17);
            Object volumenCompetitivo = tabla.getValueAt(i, 18);
            
            if (minGeneral != null && maxGeneral != null && promedioGeneral != null && insGeneral != null && semanasGeneral != null && volumenGeneral != null &&
                minEspecial != null && maxEspecial != null && promedioEspecial != null && insEspecial != null && semanasEspecial != null && volumenEspecial != null &&
                minCompetitivo != null && maxCompetitivo != null && promedioCompetitivo != null && insCompetitivo != null && semanasCompetitivo != null && volumenCompetitivo != null &&
                nombre != null) {
                lista.add(new MedioFisico(new ObjectId(), nombre.toString(), Etapa.GENERAL, Integer.parseInt(minGeneral.toString()),
                        Integer.parseInt(maxGeneral.toString()), Float.parseFloat(promedioGeneral.toString()),
                        Integer.parseInt(insGeneral.toString()), Float.parseFloat(volumenGeneral.toString())));
                
                lista.add(new MedioFisico(new ObjectId(), nombre.toString(), Etapa.ESPECIAL, Integer.parseInt(minEspecial.toString()),
                        Integer.parseInt(maxEspecial.toString()), Float.parseFloat(promedioEspecial.toString()),
                        Integer.parseInt(insEspecial.toString()), Float.parseFloat(volumenEspecial.toString())));
                
                lista.add(new MedioFisico(new ObjectId(), nombre.toString(), Etapa.COMPETITIVA, Integer.parseInt(minCompetitivo.toString()),
                        Integer.parseInt(maxCompetitivo.toString()), Float.parseFloat(promedioCompetitivo.toString()),
                        Integer.parseInt(insCompetitivo.toString()), Float.parseFloat(volumenCompetitivo.toString())));
            } else {
                JOptionPane.showMessageDialog(parent, "Ninguno de los campos debe de estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
        try {
            this.fachadaNegocio.guardarMediosFisicos(idMacrociclo, lista);
            JOptionPane.showMessageDialog(parent, "Medios físicos guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NegocioException | PersistenciaException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
