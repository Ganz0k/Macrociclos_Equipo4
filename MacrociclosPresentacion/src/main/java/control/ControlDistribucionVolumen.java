/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Macrociclo;
import entidades.MedioFisico;
import entidades.Mesociclo;
import entidades.VolumenMedioFisico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import fachadas.FachadaNegocio;
import interfaces.INegocio;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        VolumenMedioFisico[][] listaGeneral = new VolumenMedioFisico[tablaGeneral.getRowCount()][(tablaGeneral.getColumnCount() - 2) /2];
        VolumenMedioFisico[][] listaEspecial = new VolumenMedioFisico[tablaEspecial.getRowCount()][(tablaEspecial.getColumnCount() - 2) /2];
        VolumenMedioFisico[][] listaCompetitiva = new VolumenMedioFisico[tablaCompetitiva.getRowCount()][(tablaCompetitiva.getColumnCount() - 2) /2];
        List<MedioFisico> listaMedioFisico = macrociclo.getMediosFisicos();
        List<Mesociclo> listaMesociclos = macrociclo.getMesociclos();
        VolumenMedioFisico vMF = new VolumenMedioFisico();
        
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            int contadorMesociclos = 3;
            int contadorVolumenes = 0;
            
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
                        listaGeneral[i][contadorVolumenes] = vMF;
                        contadorVolumenes++;
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaEspecial.getRowCount(); i++) {
            int contadorMesociclos = 3;
            int contadorVolumenes = 0;
            
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
                        listaEspecial[i][contadorVolumenes] = vMF;
                        contadorVolumenes++;
                    }
                }
            }
        }
        
        for (int i = 0; i < tablaCompetitiva.getRowCount(); i++) {
            int contadorMesociclos = 3;
            int contadorVolumenes = 0;
            
            for (int j = 0; j < tablaCompetitiva.getColumnCount(); j++) {
                if (j > 2 && !this.isPair(j)) {
                    contadorMesociclos++;
                }
                
                Object valor = tablaCompetitiva.getValueAt(i, j);
                
                if (valor == null) {
                    JOptionPane.showMessageDialog(parent, "Todos los % y Vol. deben de tener valor", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
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
                        listaCompetitiva[i][contadorVolumenes] = vMF;
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
                    case GENERAL:
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaGeneral[i][contadorGeneral]);
                            contadorGeneral++;

                        break;
                    case ESPECIAL:
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaEspecial[i][contadorEspecial]);
                            contadorEspecial++;

                        break;
                    case COMPETITIVA:
                            this.negocio.guardarVolumenMedioFisicoEnMesociclo(macrociclo.getId(), listaMesociclos.get(j).getId(), listaCompetitiva[i][contadorCompetitivo]);
                            contadorCompetitivo++;

                        break;
                }
            }
        }
        
        JOptionPane.showMessageDialog(parent, "Distribución de volúmenes guardada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void recargarTabla(DefaultTableModel tabla, int row, int column) {
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
