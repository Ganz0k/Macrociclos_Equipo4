/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.VolumenMedioFisico;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author luisg
 */
public class ControlDistribucionVolumen {
    
    private INegocio negocio;
    
    public ControlDistribucionVolumen() {
        this.negocio = new FachadaNegocio();
    }
    
    public void guardarDistribucionesVolumenes(JFrame parent, Macrociclo macrociclo, DefaultTableModel tablaGeneral, DefaultTableModel tablaEspecial, DefaultTableModel tablaCompetitiva) {
        List<MedioFisico> listaMedioFisico = macrociclo.getMediosFisicos();
        VolumenMedioFisico vMF = new VolumenMedioFisico();
        
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            int contadorMesociclos = 3;
            
            for (int j = 0; j < tablaGeneral.getColumnCount(); j++) {
                if (j > 2 && !this.isPair(j)) {
                    contadorMesociclos++;
                }
                
                Object valor = tablaGeneral.getValueAt(i, j);
                
                if (valor instanceof String) {
                    listaMedioFisico.forEach(mF -> {
                        if (valor.equals(mF.getNombre())) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    });
                } else if (valor instanceof Float) {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        ObjectId idMesociclo = macrociclo.getMesociclos().get(contadorMesociclos).getId();
                        
                        this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), idMesociclo, vMF);
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaEspecial.getRowCount(); i++) {
            int contadorMesociclos = 3;
            
            for (int j = 0; j < tablaEspecial.getColumnCount(); j++) {
                if (j > 2 && !this.isPair(j)) {
                    contadorMesociclos++;
                }
                
                Object valor = tablaEspecial.getValueAt(i, j);
                
                if (valor instanceof String) {
                    listaMedioFisico.forEach(mF -> {
                        if (valor.equals(mF.getNombre())) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    });
                } else if (valor instanceof Float) {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        ObjectId idMesociclo = macrociclo.getMesociclos().get(contadorMesociclos).getId();
                        
                        this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), idMesociclo, vMF);
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaCompetitiva.getRowCount(); i++) {
            int contadorMesociclos = 3;
            
            for (int j = 0; j < tablaCompetitiva.getColumnCount(); j++) {
                if (j > 2 && !this.isPair(j)) {
                    contadorMesociclos++;
                }
                
                Object valor = tablaCompetitiva.getValueAt(i, j);
                
                if (valor instanceof String) {
                    listaMedioFisico.forEach(mF -> {
                        if (valor.equals(mF.getNombre())) {
                            vMF.setMedioFisico(mF.getId());
                        }
                    });
                } else if (valor instanceof Float) {
                    if (j > 1 && this.isPair(j)) {
                        vMF.setVolumen((float) valor);
                    } else if (j > 1 && !this.isPair(j)) {
                        vMF.setPorcentaje((float) valor);
                        vMF.setId(new ObjectId());
                        ObjectId idMesociclo = macrociclo.getMesociclos().get(contadorMesociclos).getId();
                        
                        this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), idMesociclo, vMF);
                    }
                }
            }
        }
    }
    
    private boolean isPair(int numero) {
        return numero % 2 == 0;
    }
}
