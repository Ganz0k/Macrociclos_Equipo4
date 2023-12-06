/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import entidades.MedioFisico;
import enumeradores.Etapa;
import enumeradores.Operacion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachadas.FachadaNegocio;
import guis.DistribucionVolumenFrame;
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
    
    private final INegocio fachadaNegocio;
    
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
    
    public void acrualizarMediosFisicos(JFrame parent, Macrociclo macrociclo, DefaultTableModel tabla) {
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
            this.fachadaNegocio.actualizarMediosFisicos(macrociclo.getId(), lista);
            JOptionPane.showMessageDialog(parent, "Medios físicos guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            new DistribucionVolumenFrame(this.fachadaNegocio.obtenerMacrociclo(macrociclo.getId()), Operacion.ACTUALIZAR).setVisible(true);
            parent.dispose();
        } catch (NegocioException | PersistenciaException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void guardarMediosFisicos(JFrame parent, Macrociclo macrociclo, DefaultTableModel tabla) {
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
            if (this.fachadaNegocio.validarMediosFisicos(macrociclo.getId(), lista)) {
                JOptionPane.showMessageDialog(parent, "Medios físicos guardados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                new DistribucionVolumenFrame(macrociclo, Operacion.CREAR).setVisible(true);
                parent.dispose();
            }
        } catch (NegocioException ne) {
            JOptionPane.showMessageDialog(parent, ne.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarTabla(Macrociclo macrociclo, DefaultTableModel tabla) {
        tabla.setRowCount(0);
        Object[] fila = new Object[21];
        List<MedioFisico> mediosFisicos = macrociclo.getMediosFisicos();
        
        for (int i = 0; i < mediosFisicos.size(); i += 3) {
            fila[0] = mediosFisicos.get(i).getNombre();
            fila[1] = mediosFisicos.get(i).getMinimo();
            fila[2] = mediosFisicos.get(i).getMaximo();
            fila[3] = mediosFisicos.get(i).getPromedio();
            fila[4] = mediosFisicos.get(i).getVecesPorSemana();
            
            if (mediosFisicos.get(i).getVolumen() == 0) {
                fila[5] = 0;
            } else {
                fila[5] = Math.round(mediosFisicos.get(i).getVolumen() / (mediosFisicos.get(i).getPromedio() * mediosFisicos.get(i).getVecesPorSemana()));
            }
            
            fila[6] = mediosFisicos.get(i).getVolumen();
            fila[7] = mediosFisicos.get(i + 1).getMinimo();
            fila[8] = mediosFisicos.get(i + 1).getMaximo();
            fila[9] = mediosFisicos.get(i + 1).getPromedio();
            fila[10] = mediosFisicos.get(i + 1).getVecesPorSemana();
            
            if (mediosFisicos.get(i + 1).getVolumen() == 0) {
                fila[11] = 0;
            } else {
                fila[11] = Math.round(mediosFisicos.get(i + 1).getVolumen() / (mediosFisicos.get(i + 1).getPromedio() * mediosFisicos.get(i + 1).getVecesPorSemana()));
            }
            
            fila[12] = mediosFisicos.get(i + 1).getVolumen();
            fila[13] = mediosFisicos.get(i + 2).getMinimo();
            fila[14] = mediosFisicos.get(i + 2).getMaximo();
            fila[15] = mediosFisicos.get(i + 2).getPromedio();
            fila[16] = mediosFisicos.get(i + 2).getVecesPorSemana();
            
            if (mediosFisicos.get(i + 2).getVolumen() == 0) {
                fila[17] = 0;
            } else {
                fila[17] = Math.round(mediosFisicos.get(i + 2).getVolumen() / (mediosFisicos.get(i + 2).getPromedio() * mediosFisicos.get(i + 2).getVecesPorSemana()));
            }
            
            fila[18] = mediosFisicos.get(i + 2).getVolumen();
            fila[19] = mediosFisicos.get(i).getVolumen() + mediosFisicos.get(i + 1).getVolumen() + mediosFisicos.get(i + 2).getVolumen();
            tabla.addRow(fila);
        }
    }
}
